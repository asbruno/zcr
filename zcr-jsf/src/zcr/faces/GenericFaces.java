package zcr.faces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class GenericFaces {

    protected void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
