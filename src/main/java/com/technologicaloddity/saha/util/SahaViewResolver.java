/**
 * (c) 2010 Technological Oddity
 *     http://technologicaloddity.com
 *
 * I, Bob Robinson, the author of this work hereby release it
 * under the Creative Commons-By Attribution 3.0 license for
 * both commercial and non-commercial purposes.
 * See the license at:
 * http://creativecommons.org/licenses/by/3.0/
 */
package com.technologicaloddity.saha.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
@Component
public class SahaViewResolver extends UrlBasedViewResolver {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.UrlBasedViewResolver#getViewClass()
	 */
	@Override
	protected Class<JstlView> getViewClass() {
		return JstlView.class;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.UrlBasedViewResolver#getPrefix()
	 */
	@Override
	protected String getPrefix() {
		return "/WEB-INF/jsp/";
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.UrlBasedViewResolver#getSuffix()
	 */
	@Override
	protected String getSuffix() {
		return ".jsp";
	}
}
