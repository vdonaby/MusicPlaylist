package com.msse.web.repository

import com.msse.web.domain.Release
import org.springframework.data.repository.CrudRepository

/**
 * Created by z001hk8 on 2/8/17.
 */

interface ReleaseRepository extends CrudRepository<Release, Long> {}