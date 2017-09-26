package com.gaia.service;

import java.util.List;

import com.gaia.utils.Groups;
import com.gaia.utils.PageObj;
import com.gaia.vo.account.AuthorityVo;

public interface AccountService {
	
	
	PageObj findAuthorityPageByGroups(Groups groups, PageObj page);
	List<AuthorityVo> findAuthorityByGroups(Groups groups);
	void saveAuthority(AuthorityVo authorityVo) throws Exception;
	void updateAuthority(AuthorityVo authorityVo) throws Exception;
	void deleteAuthority(Long id) throws Exception;

}
