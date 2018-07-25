package cn.tedu.cloudnote.test;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.EmpDao;
import cn.tedu.cloudnote.entity.Emp;

public class TestEmpDao extends TestBase{
	private EmpDao empDao;
	@Before
	public void init(){
		empDao=super.getContext().getBean(
			"empDao", EmpDao.class);		
	}
	@Test
	public void test(){
		Emp emp=new Emp();
		emp.setName("Andy");
		emp.setAge(18);
		empDao.save(emp);
		System.out.println(
			"刚刚生成的id:"+emp.getId());
	}
}






