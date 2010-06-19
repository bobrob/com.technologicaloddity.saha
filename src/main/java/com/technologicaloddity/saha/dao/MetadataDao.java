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
package com.technologicaloddity.saha.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.technologicaloddity.saha.model.Metadata;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
@Component
public class MetadataDao extends MappedModelDao<Metadata> {

	/* (non-Javadoc)
	 * @see com.technologicaloddity.saha.dao.MappedModelDao#getActualClass()
	 */
	@Override
	public Class<Metadata> getActualClass() {
		return Metadata.class;
	}
	
	public Metadata getNameMetadata() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(getActualClass());
		criteria.add(Restrictions.eq("metakey", "name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setMaxResults(1);
		Metadata result = (Metadata)criteria.uniqueResult();
		if(result == null) {
			result = new Metadata();
			result.setMetakey("name");
			result.setMetavalue(null);
		}
		return result;
	}

}
