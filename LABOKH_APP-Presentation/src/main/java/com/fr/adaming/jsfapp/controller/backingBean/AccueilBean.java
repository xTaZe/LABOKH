package com.fr.adaming.jsfapp.controller.backingBean;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fr.adaming.jsfapp.controller.SuperFacade;

@ManagedBean
@Controller("accueilBean")
@Scope("session")
public class AccueilBean extends SuperFacade {
}
