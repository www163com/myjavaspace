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
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�UsersRepostiryTest   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-8 ����4:22:59   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-8 ����4:22:59   
* �޸ı�ע��   
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
		users.setAddress("�����");
		users.setAge(24);
		users.setName("����");
		this.usersRepostory.save(users);
	}
	/**
	 * Repository--��������������ѯ����
	 */
	@Test
	public void testFindByName(){
		List<Users> list = this.usersRepositoryByName.findByName("����");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository--��������������ѯ����
	 */
	@Test
	public void testFindByNameAndAge(){
		List<Users> list = this.usersRepositoryByName.findByNameAndAge("����",20);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository--��������������ѯ����
	 */
	@Test
	public void testFindByNameLike(){
		List<Users> list = this.usersRepositoryByName.findByNameLike("��%");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository -@Query����
	 */
	@Test
	public void queryByNameUseHQL(){
		List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("����");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository -@Query����
	 */
	@Test
	public void queryByNameUseSQL(){
		List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL("����");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * Repository -@Query����
	 */
	@Test
	@Transactional //@Transactional��@Testһ��ʹ��ʱ �������Զ��ع���
	@Rollback(false)//ȡ���Զ��ع�
	public void updateUsersNameById(){
		this.usersRepositoryQueryAnnotation.updateUsersNameById("������",1);
	}
	
	/**
	 * CrudRepository --����
	 */
	@Test
	public void testCrudRepositorySave(){
		Users user = new Users();
		user.setAddress("����");
		user.setAge(32);
		user.setName("����");
		this.usersRepositoryCrudRepository.save(user);
	}
	/**
	 * CrudRepository --����
	 */
	@Test
	public void testCrudRepositoryUpdate(){
		Users user = new Users();
		user.setId(4);
		user.setAddress("�Ͼ�");
		user.setAge(40);
		user.setName("����");
		this.usersRepositoryCrudRepository.save(user);
	}
	/**
	 * CrudRepository --����
	 */
	@Test
	public void testCrudRepositoryFindOne(){
		Optional<Users> user = this.usersRepositoryCrudRepository.findById(4);
		System.out.println(user);
	}
	/**
	 * CrudRepository --����
	 */
	@Test
	public void testCrudRepositoryFindAll(){
		List<Users> list = (List<Users>) this.usersRepositoryCrudRepository.findAll();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * CrudRepository --����
	 */
	@Test
	public void testCrudRepositoryDeletById(){
		this.usersRepositoryCrudRepository.deleteById(4);
	}
	/**
	 * PagingAndSortingRepository --�������
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPagingAndSortingRepositorySort(){
		//Order �����������
		Order order = new Order(Direction.DESC,"id");
		//sort�����װ���������
		Sort sort =  new Sort(order);
		List<Users> list = (List<Users>) this.usersRepositoryPadingAndSorting.findAll(sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * PagingAndSortingRepository --��ҳ����
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPagingAndSortingRepositoryPaging(){
		//Pageable:��װ�˷�ҳ�Ĳ�������ǰҳ��û����ʾ��������ע�����ĵ�ǰҳ�Ǵ�0��ʼ��
		//PageRequest(page, size) page��ǰҳ  sizeÿҳ����
		Pageable pageable = new PageRequest(0, 2);
		Page<Users> page = this.usersRepositoryPadingAndSorting.findAll(pageable);
		System.out.println("����������:"+page.getTotalElements());
		System.out.println("��ҳ��:"+page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * PagingAndSortingRepository --����+��ҳ����
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPagingAndSortingRepositorySortAndPaging(){
		//Order �����������
		Order order = new Order(Direction.DESC,"id");
		//sort�����װ���������
		Sort sort =  new Sort(order);
		//Pageable:��װ�˷�ҳ�Ĳ�������ǰҳ��û����ʾ��������ע�����ĵ�ǰҳ�Ǵ�0��ʼ��
		//PageRequest(page, size) page��ǰҳ  sizeÿҳ����
		Pageable pageable = new PageRequest(0, 2 ,sort);
		Page<Users> page = this.usersRepositoryPadingAndSorting.findAll(pageable);
		System.out.println("����������:"+page.getTotalElements());
		System.out.println("��ҳ��:"+page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * JpaRepository --�������
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testJpaRepositorySort(){
		//Order �����������
		Order order = new Order(Direction.DESC,"id");
		//sort�����װ���������
		Sort sort =  new Sort(order);
		List<Users> list = this.usersRepostory.findAll(sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * JpaSpecificationExecutor ����������
	 */
	@Test
	public void testJpaSpecificationExecutor1(){
		Specification<Users> specification = new Specification<Users>(){
			//Predicate ��װ�˵�����ѯ����
			
			/**
			 * @param root ��ѯ��������Եķ�װ
			 * @param query ��װ��Ҫִ�еĲ�ѯ�еĸ������ֵ���Ϣ select from  order by
			 * @param cb ��ѯ�����Ĺ����������岻ͬ�Ĳ�ѯ����
			 * @return
			 */
			@Override
			@Nullable
			public Predicate toPredicate(Root<Users> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				//where name = '������'
				//����һ����ǰ��ѯ������
				//����������ǰ��ѯ������ֵ
				Predicate pre = cb.equal(root.get("name"), "������");
				return pre;
			}
		};
		List<Users> list = this.usersRepositorySpecification.findAll(specification);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	/**
	 * JpaSpecificationExecutor ����������
	 */
	@Test
	public void testJpaSpecificationExecutor2(){
		Specification<Users> specification = new Specification<Users>(){
			//Predicate ��װ�˵�����ѯ����
			
			/**
			 * @param root ��ѯ��������Եķ�װ
			 * @param query ��װ��Ҫִ�еĲ�ѯ�еĸ������ֵ���Ϣ select from  order by
			 * @param cb ��ѯ�����Ĺ����������岻ͬ�Ĳ�ѯ����
			 * @return
			 */
			@Override
			@Nullable
			public Predicate toPredicate(Root<Users> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				//where name = '������' and age = 20
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"), "������"));
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
	 * JpaSpecificationExecutor ���������Եڶ���д��
	 */
	@Test
	public void testJpaSpecificationExecutor3(){
		Specification<Users> specification = new Specification<Users>(){
			//Predicate ��װ�˵�����ѯ����
			
			/**
			 * @param root ��ѯ��������Եķ�װ
			 * @param query ��װ��Ҫִ�еĲ�ѯ�еĸ������ֵ���Ϣ select from  order by
			 * @param cb ��ѯ�����Ĺ����������岻ͬ�Ĳ�ѯ����
			 * @return
			 */
			@Override
			@Nullable
			public Predicate toPredicate(Root<Users> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				//name = '������' and age=20 or id =2
				return cb.or(cb.and(cb.equal(root.get("name"), "������"),cb.equal(root.get("age"), 20)),cb.equal(root.get("id"), 2));
			}
		};
		Sort sort = new Sort(new Order(Direction.DESC,"id"));
		List<Users> list = this.usersRepositorySpecification.findAll(specification,sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}
}