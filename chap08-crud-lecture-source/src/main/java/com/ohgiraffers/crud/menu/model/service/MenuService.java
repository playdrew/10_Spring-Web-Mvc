package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper){
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenus() {

        return menuMapper.findAllMenus();
    }

    public List<CategoryDTO> findAllCategory() {

        return menuMapper.findAllCategory();
    }

    /* comment.
    *   스프링 프레임워크에서 제공하는 트랜젝션 관리 어노테이션으로
    *   데이터베이스의 상태를 변화시키는 작업(DML) 을 하나의 단위로
    *   묶는 것을 의미한다. 따라서 데이터베이스 조작에 관련 된 일이
    *   일어 날때 메소드의 실행이 정상적으로 완료되면 commit,
    *   예외가 발생하면 rollback 을 수행하여
    *   데이터의 일관성을 유지하는데 사용된다.
    *   내부적으로 AOP 기능을 사용하고 있다.
    * */
    // 시작함과 동시에 이후에 일어나는 작업 매퍼 쿼리호출 등을 묶어요.
    // 임무를 완수하고 컨트롤러로 돌아가기전까지 에러가 발생시 rollback 을 시켜요.
    // db에 이상한 값이 들어가는 것을 막게 되요.
    @Transactional
    public void registMenu(MenuDTO newMenu) {

        menuMapper.registNewMenu(newMenu);
    }

    public List<MenuDTO> findMenuByName(String menuName) {

        return menuMapper.findMenuByName(menuName);
    }

    public List<MenuAndCategoryDTO> findAllMenuAndCategory() {

        return menuMapper.findAllMenuAndCategory();
    }

    public void deleteByCode(int menuCode) {

        menuMapper.deleteByCode(menuCode);
    }
}
