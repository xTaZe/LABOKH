package com.fr.adaming.jsfapp.util;

public interface IBean {

	/**
	 * cette méthode permet d'initialiser les paramètres d'un contrôleur et
	 * d'afficher une interface
	 * 
	 * @return retourner la page qui va être affichée
	 */
	String init();

	/**
	 * cette méthode permet de créer un nouveau enregistrement
	 * 
	 * @return retourner une page ou null
	 */
	String nouveauEnregistrement();

	/**
	 * cette méthode permet de modifier ou d'afficher les détails d'un
	 * enregistrement
	 * 
	 * @return retourner la fiche détaillée d'un enregistrement
	 */
	String editEnregistrement();

	String detailsEnregistrement();

	/**
	 * cette méthode permet de supprimer un enregistrement
	 * 
	 * @return retourner une page ou null
	 */
	String deleteEnregistrement();

	/**
	 * cette méthode consiste à récupérer un objet ou une liste d'objet
	 * 
	 * @return retourner l'objet ou la liste récupéré
	 */
	String rechercher();

	/**
	 * cette méthode permet sauvegarder un enregistrement
	 * 
	 * @return retourner une page ou null
	 */
	String saveEnregistrement();

}
