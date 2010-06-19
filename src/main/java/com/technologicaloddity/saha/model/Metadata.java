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
package com.technologicaloddity.saha.model;

import javax.persistence.*;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
@Entity
@Table(name="metadata")
public class Metadata extends MappedModel {

	@Column
	String metakey;
	
	@Column
	String metavalue;

	/**
	 * @return the metakey
	 */
	public String getMetakey() {
		return metakey;
	}

	/**
	 * @param metakey the metakey to set
	 */
	public void setMetakey(String metakey) {
		this.metakey = metakey;
	}

	/**
	 * @return the metavalue
	 */
	public String getMetavalue() {
		return metavalue;
	}

	/**
	 * @param metavalue the metavalue to set
	 */
	public void setMetavalue(String metavalue) {
		this.metavalue = metavalue;
	}


}
