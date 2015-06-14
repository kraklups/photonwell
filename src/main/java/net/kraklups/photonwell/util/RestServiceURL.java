package net.kraklups.photonwell.util;

import java.net.URL;

public class RestServiceURL {
	
	private URL urlREST;

	public URL getUrlREST() {
		
		return urlREST;
		
	}

	public void setUrlREST(URL urlREST) {
		
		this.urlREST = urlREST;
		
	}
	
	@Override
	public String toString() {
		return "ValueObject [urlREST=" + urlREST + "]";
	}

}
