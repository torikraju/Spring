package org.torikraju.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.torikraju.domain.UserInfo;

public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, Long> {

    //(Pageable pageable);

}
