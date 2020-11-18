package com.fr.adaming.jsfapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.jsfapp.dao.IMailDAO;
import com.fr.adaming.jsfapp.model.Mail;

@Repository("mailDAO")
public class MailDAO extends ManagerDao<Mail> implements IMailDAO {

}
