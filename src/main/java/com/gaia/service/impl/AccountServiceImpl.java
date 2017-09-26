package com.gaia.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gaia.entity.account.Authority;
import com.gaia.repository.account.AuthorityRepository;
import com.gaia.service.AccountService;
import com.gaia.utils.Groups;
import com.gaia.utils.PageObj;
import com.gaia.vo.account.AuthorityVo;

@Transactional(readOnly=true)
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AuthorityRepository authorityRepository;
	

	@Override
	public PageObj findAuthorityPageByGroups(Groups groups, PageObj page) {
		authorityRepository.findEntityPageByGroups(groups, page);
		page.setItems(Authority.toVoList(page.getItems()));
		
		return page;
	}

	@Override
	public List<AuthorityVo> findAuthorityByGroups(Groups groups) {
		List<Authority> authoritys = authorityRepository.findEntityByGroups(groups);
		return Authority.toVoList(authoritys);
	}

	@Transactional
	@Override
	public void saveAuthority(AuthorityVo authorityVo) throws Exception {
		Authority authority = Authority.fromVo(authorityVo);
		authorityRepository.save(authority);
	}

	@Transactional
	@Override
	public void updateAuthority(AuthorityVo authorityVo) throws Exception {
		Authority authority = authorityRepository.find(authorityVo.getId());
		authority.setName(authorityVo.getName());
		authority.setCode(authorityVo.getCode());
		authority.setMethod(authorityVo.getMethod());
		authority.setSort(authorityVo.getSort());
		authority.setUrl(authorityVo.getUrl());
		authority.setIcons(authorityVo.getIcons());
		Long parentId = authorityVo.getParentId();
		if(parentId != null){
			authority.setParent(new Authority(parentId));
		}
		authorityRepository.save(authority);
	}

	@Transactional
	@Override
	public void deleteAuthority(Long id) throws Exception {
		authorityRepository.delete(id);
	}

	

	

}
