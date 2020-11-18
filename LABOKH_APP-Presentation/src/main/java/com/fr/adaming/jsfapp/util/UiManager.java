package com.fr.adaming.jsfapp.util;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.event.MethodExpressionValueChangeListener;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;

@SuppressWarnings("el-syntax")
public abstract class UiManager {

	protected static final String RESOURCE_BUNDLE_NAME = "gen";
	protected static final String DATA_TABLE_IMAGE_FILTRE = "/images/icons/filter.gif";

	public UiManager() {
	}

	protected ValueExpression getValueExpression(String expression, Class<?> classe) {
		return FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
				.createValueExpression(FacesContext.getCurrentInstance().getELContext(), expression, classe);
	}

	protected MethodExpression getMethodExpression(String expression) {
		return FacesContext
				.getCurrentInstance()
				.getApplication()
				.getExpressionFactory()
				.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), expression, null,
						new Class[0]);
	}

	protected MethodExpression getMethodExpressionActionEvent(String expression) {
		return FacesContext
				.getCurrentInstance()
				.getApplication()
				.getExpressionFactory()
				.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), expression, null,
						new Class[] { ActionEvent.class });
	}

	protected MethodExpressionActionListener getMethodExpressionActionListener(String expression) {
		MethodExpressionActionListener valueActionListener = new MethodExpressionActionListener(
				getMethodExpressionActionEvent(expression));
		return valueActionListener;
	}

	protected MethodExpression getMethodExpressionValueChangeEvent(String expression) {
		return FacesContext
				.getCurrentInstance()
				.getApplication()
				.getExpressionFactory()
				.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), expression, null,
						new Class[] { ValueChangeEvent.class });
	}

	protected MethodExpressionValueChangeListener getMethodExpressionValueChangeListener(String expression) {
		MethodExpressionValueChangeListener valueChangeListener = new MethodExpressionValueChangeListener(
				getMethodExpressionValueChangeEvent(expression));
		return valueChangeListener;
	}

	public static String getValFromResourceBundle(String bundle, String name) {
		String l_bundle = null;
		if (bundle == null) {
			l_bundle = RESOURCE_BUNDLE_NAME;
		} else {
			l_bundle = bundle;
		}
		String val = null;
		if (name != null) {
			ResourceBundle rb = FacesContext.getCurrentInstance().getApplication()
					.getResourceBundle(FacesContext.getCurrentInstance(), l_bundle);
			val = rb.getString(name);

		}
		return val;
	}

	public static String getValFromResourceBundle(String name) {
		return getValFromResourceBundle(null, name);
	}

	protected void gotoPage(String pageName) {
		if (pageName != null) {
			FacesContext context = getFacesContext();
			UIViewRoot newView = context.getApplication().getViewHandler().createView(context, pageName);
			context.setViewRoot(newView);
			context.renderResponse();
		}
	}

	public static UIComponent findComponent(UIComponent base, String id) {

		if (id.equals(base.getId())) {
			return base;
		}
		UIComponent kid = null;
		UIComponent result = null;
		Iterator<?> kids = base.getFacetsAndChildren();
		while (kids.hasNext() && (result == null)) {
			kid = (UIComponent) kids.next();
			if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
			result = findComponent(kid, id);
			if (result != null) {
				break;
			}
		}
		return result;
	}

	public static UIComponent findComponentInRoot(String id) {
		UIComponent ret = null;

		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			UIComponent root = context.getViewRoot();
			ret = findComponent(root, id);
		}

		return ret;
	}

	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
	}

	protected void putTreeAttribute(String key, Object value) {
		getFacesContext().getViewRoot().getAttributes().put(key, value);
	}

	protected Object getTreeAttribute(String key) {
		return getFacesContext().getViewRoot().getAttributes().get(key);
	}

	protected Object resolveExpression(String expression) {
		Object value = null;
		if ((expression.indexOf("#{") != -1) && (expression.indexOf("#{") < expression.indexOf('}'))) {
			value = getFacesContext().getApplication().getExpressionFactory()
					.createValueExpression(getFacesContext().getELContext(), expression, Object.class)
					.getValue(getFacesContext().getELContext());
		} else {
			value = expression;
		}
		return value;
	}

	protected Object getManagedBean(String mgdBeanName) {
		String expression = "#{" + mgdBeanName + "}";
		return resolveExpression(expression);
	}

	protected void resolveParams(Map<String, Object> paramMap, String[] argNames, String[] argValues, String cacheMapKey) {

		Object rawCache = getTreeAttribute(cacheMapKey);
		Map<?, ?> cache = Collections.EMPTY_MAP;
		if (rawCache instanceof Map) {
			cache = (Map<?, ?>) rawCache;
		}
		for (int i = 0; i < argNames.length; i++) {
			Object result = resolveExpression(argValues[i]);
			if (result == null) {
				result = cache.get(argNames[i]);
			}
			paramMap.put(argNames[i], result);
		}
		putTreeAttribute(cacheMapKey, paramMap);
	}

	public static String getRealPath(String relPath) {
		String path = relPath;
		try {
			URL url = FacesContext.getCurrentInstance().getExternalContext().getResource(relPath);
			if (url != null) {
				path = url.getPath();
			}
		} catch (MalformedURLException e) {
			e.getMessage();
		}
		return path;
	}

	public static String getAbsolutePath(String relPath) {

		String path = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath(relPath);
		return path;
	}

	protected static InputStream getResourceInputStream(String relPath) {
		return FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(relPath);
	}

	protected void logException(Throwable throwable) {
		StringWriter stringWriter = new StringWriter();
		stringWriter.write(throwable.getMessage());
		log(stringWriter.toString());
	}

	public static String getBeanName(Object bean) {

		String res = null;
		if (bean != null) {
			Class<? extends Object> c = bean.getClass();
			if (c.isAnnotationPresent(org.springframework.stereotype.Controller.class)) {
				Controller b = c.getAnnotation(Controller.class);
				res = b.value();
			}
		}
		return res;
	}

	protected void log(String message) {
		System.out.println(message);
	}

	public Map<?, ?> getApplicationScope() {
		return getFacesContext().getExternalContext().getApplicationMap();
	}

	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public Map<?, ?> getRequestParam() {
		return getFacesContext().getExternalContext().getRequestParameterMap();
	}

	public Map<?, ?> getRequestScope() {
		return getFacesContext().getExternalContext().getRequestMap();
	}

	public Map<?, ?> getSessionScope() {
		return getFacesContext().getExternalContext().getSessionMap();
	}

	public static Object getObjectSession(String bean) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(bean);
	}

}
