package com.billyang.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.billyang.App22;
import com.billyang.dao.UsersRepository;
import com.billyang.dao.UsersRepositoryByName;
import com.billyang.dao.UsersRepositoryCrudRepository;
import com.billyang.dao.UsersRepositoryPadingAndSorting;
import com.billyang.dao.UsersRepositoryQueryAnnotation;
import com.billyang.dao.UsersRepositorySpecification;
import com.billyang.pojo.Users;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：UsersRepostiryTest   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-8 下午4:22:59   
* 修改人：yangcan14944   
* 修改时间：2018-10-8 下午4:22:59   
* 修改备注：   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App22.class)
public class UsersRepostiryTest {
	@Autowired
	private UsersRepository usersRepostory;
	@Autowired
	private UsersRepositoryByName usersRepositoryByName;
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	@Autowired
	private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
	@Autowired
	private UsersRepositoryPadingAndSorting usersRepositoryPadingAndSorting;
	@Autowired
	private UsersRepositorySpecification usersRepositorySpecification;
	@Test
	public void testSave(){
		Users users = new Users();
		users.setAddress("天津市");
		users.setAge(24);
		users.setName("王五");
		this.usersRepostory.save(users);
	}
	/**
	 * Repository--方法名称命名查询测试
	 */
	@Test
	public void testFindByName(){
		List<Users> list = this.usersRepositoryByName.findByName("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository--方法名称命名查询测试
	 */
	@Test
	public void testFindByNameAndAge(){
		List<Users> list = this.usersRepositoryByName.findByNameAndAge("张三",20);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository--方法名称命名查询测试
	 */
	@Test
	public void testFindByNameLike(){
		List<Users> list = this.usersRepositoryByName.findByNameLike("张%");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository -@Query测试
	 */
	@Test
	public void queryByNameUseHQL(){
		List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository -@Query测试
	 */
	@Test
	public void queryByNameUseSQL(){
		List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository -@Query测试
	 */
	@Test
	@Transactional //@Transactional与@Test一起使用时 事务是自动回滚的
	@Rollback(false)//取消自动回滚
	public void updateUsersNameById(){
		this.usersRepositoryQueryAnnotation.updateUsersNameById("张三四",1);
	}
	
	/**
	 * CrudRepository --测试
	 */
	@Test
	public void testCrudRepositorySave(){
		Users user = new Users();
		user.setAddress("重庆");
		user.setAge(32);
		user.setName("赵六");
		this.usersRepositoryCrudRepository.save(user);
	}
	/**
	 * CrudRepository --测试
	 */
	@Test
	public void testCrudRepositoryUpdate(){
		Users user = new Users();
		user.setId(4);
		user.setAddress("南京");
		user.setAge(40);
		user.setName("赵六");
		this.usersRepositoryCrudRepository.save(user);
	}
	/**
	 * CrudRepository --测试
	 */
	@Test
	public void testCrudRepositoryFindOne(){
		Optional<Users> user = this.usersRepositoryCrudRepository.findById(4);
		System.out.println(user);
	}
	/**
	 * CrudRepository --测试
	 */
	@Test
	public void testCrudRepositoryFindAll(){
		List<Users> list = (List<Users>) this.usersRepositoryCrudRepository.findAll();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * CrudRepository --测试
	 */
	@Test
	public void testCrudRepositoryDeletById(){
		this.usersRepositoryCrudRepository.deleteById(4);
	}
	/**
	 * PagingAndSortingRepository --排序测试
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPagingAndSortingRepositorySort(){
		//Order 定义排序规则
		Order order = new Order(Direction.DESC,"id");
		//sort对象封装了排序规则
		Sort sort =  new Sort(order);
		List<Users> list = (List<Users>) this.usersRepositoryPadingAndSorting.findAll(sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * PagingAndSortingRepository --分页测试
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPagingAndSortingRepositoryPaging(){
		//Pageable:封装了分页的参数。当前页，没有显示的条数。注意他的当前页是从0开始的
		//PageRequest(page, size) page当前页  size每页条数
		Pageable pageable = new PageRequest(0, 2);
		Page<Users> page = this.usersRepositoryPadingAndSorting.findAll(pageable);
		System.out.println("数据总条数:"+page.getTotalElements());
		System.out.println("总页数:"+page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * PagingAndSortingRepository --排序+分页测试
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPagingAndSortingRepositorySortAndPaging(){
		//Order 定义排序规则
		Order order = new Order(Direction.DESC,"id");
		//sort对象封装了排序规则
		Sort sort =  new Sort(order);
		//Pageable:封装了分页的参数。当前页，没有显示的条数。注意他的当前页是从0开始的
		//PageRequest(page, size) page当前页  size每页条数
		Pageable pageable = new PageRequest(0, 2 ,sort);
		Page<Users> page = this.usersRepositoryPadingAndSorting.findAll(pageable);
		System.out.println("数据总条数:"+page.getTotalElements());
		System.out.println("总页数:"+page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * JpaRepository --排序测试
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testJpaRepositorySort(){
		//Order 定义排序规则
		Order order = new Order(Direction.DESC,"id");
		//sort对象封装了排序规则
		Sort sort =  new Sort(order);
		List<Users> list = this.usersRepostory.findAll(sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * JpaSpecificationExecutor 单条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor1(){
		Specification<Users> specification = new Specification<Users>(){
			//Predicate 封装了单个查询条件
			
			/**
			 * @param root 查询对象的属性的封装
			 * @param query 封装了要执行的查询中的各个部分的信息 select from  order by
			 * @param cb 查询条件的构造器。定义不同的查询条件
			 * @return
			 */
			@Override
			@Nullable
			public Predicate toPredicate(Root<Users> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				//where name = '张三四'
				//参数一：当前查询的属性
				//参数二：当前查询条件的值
				Predicate pre = cb.equal(root.get("name"), "张三四");
				return pre;
			}
		};
		List<Users> list = this.usersRepositorySpecification.findAll(specification);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * JpaSpecificationExecutor 多条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor2(){
		Specification<Users> specification = new Specification<Users>(){
			//Predicate 封装了单个查询条件
			
			/**
			 * @param root 查询对象的属性的封装
			 * @param query 封装了要执行的查询中的各个部分的信息 select from  order by
			 * @param cb 查询条件的构造器。定义不同的查询条件
			 * @return
			 */
			@Override
			@Nullable
			public Predicate toPredicate(Root<Users> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				//where name = '张三四' and age = 20
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"), "张三四"));
				list.add(cb.equal(root.get("age"), 20));
				Predicate[] arr = new Predicate[list.size()];
				return cb.and(list.toArray(arr));
			}
		};
		List<Users> list = this.usersRepositorySpecification.findAll(specification);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * JpaSpecificationExecutor 多条件测试第二种写法
	 */
	@Test
	public void testJpaSpecificationExecutor3(){
		Specification<Users> specification = new Specification<Users>(){
			//Predicate 封装了单个查询条件
			
			/**
			 * @param root 查询对象的属性的封装
			 * @param query 封装了要执行的查询中的各个部分的信息 select from  order by
			 * @param cb 查询条件的构造器。定义不同的查询条件
			 * @return
			 */
			@Override
			@Nullable
			public Predicate toPredicate(Root<Users> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				//name = '张三四' and age=20 or id =2
				return cb.or(cb.and(cb.equal(root.get("name"), "张三四"),cb.equal(root.get("age"), 20)),cb.equal(root.get("id"), 2));
			}
		};
		Sort sort = new Sort(new Order(Direction.DESC,"id"));
		List<Users> list = this.usersRepositorySpecification.findAll(specification,sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}
}
