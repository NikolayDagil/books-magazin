/**
 * 
 */
package org.nikolay.books.test.dpl.base;

import java.io.Serializable;

import org.nikolay.books.api.dao.base.IBaseDAO;

/**
 * @author Nikolay Dagil
 * 
 */
public abstract class BaseDAOTest<I, PK extends Serializable, DAO extends IBaseDAO<I, PK>> {

	/*protected static final String TEST_A_STRING = "Test A";
	protected static final String TEST_B_STRING = "Test B";

	IBaseDAO<I, Long> iBaseDAO = new IBaseDAO<I, Long>() {

		@Override
		public void save(I i) {
			// TODO Auto-generated method stub
			int rowCount = 0;
			List<I> is = null;

			is = iBaseDAO.list();

			Assert.assertNotNull(is);
			rowCount = is.size();

			I i1 = new I();
			i1.setFirstName(TEST_A_STR);
			i1.setLastName(TEST_A_STR);
			i1.setUsername(TEST_A_STR);
			i1.setEmail(TEST_A_STR);
			i1.setIsActive(TEST_TRUE);
			iBaseDAO.save(i1);

			is = iBaseDAO.list();

			Assert.assertNotNull(is);
			Assert.assertEquals(rowCount + 1, is.size());

		}

		@Override
		public void update(I i) {
			// TODO Auto-generated method stub

		}

		@Override
		public void delete(I i) {
			// TODO Auto-generated method stub

		}

		@Override
		public I getId(Long PK) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<I> list() {
			// TODO Auto-generated method stub
			return null;
		}
	};*/

}