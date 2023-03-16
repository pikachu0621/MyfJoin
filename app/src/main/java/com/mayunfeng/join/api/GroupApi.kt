package com.mayunfeng.join.api

import com.mayunfeng.join.bean.BaseBean
import com.mayunfeng.join.bean.GroupBean
import io.reactivex.rxjava3.core.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *
 * @ProjectName:    考勤记录管理系统
 * @Package:        com.mayunfeng.join.api
 * @Author:         pkpk.run
 * @Description:    null
 */
interface GroupApi {

    /**
     * 创建组
     *
     * @return {@linkplain Observable<BaseBean<Array<String>>>}
     */
    @POST("/myf-group-api/create")
    fun sendCreateGroup(
        @Body body: RequestBody // 带其他参数的    不要 @Multipart
    ): Observable<BaseBean<GroupBean>>


    /**
     * 获取用户创建的群组
     */
    @GET("/myf-group-api/user-create-group")
    fun sendUserCreateGroup(): Observable<BaseBean<ArrayList<GroupBean>>>

}