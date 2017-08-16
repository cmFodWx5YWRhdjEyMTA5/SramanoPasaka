package com.sramanopasaka.sipanionline.sadhumargi.listener;

import com.google.gson.JsonObject;
import com.sramanopasaka.sipanionline.sadhumargi.PasswordChangeResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.AchievementListResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.AddAchievementResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.AddAddressResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.AddBusinessResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.AddressListResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.BasicDetailsResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.BusinessListResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.DeleteAchievementResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.DeleteAddressResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.DeleteBusinessResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.DharmikDetailsResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.LoginResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.RegisterResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.UpdateBasicDetailsResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.UpdateKnowledgeResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.UpdatePromiseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Name    :   pranavjdev
 * Date   : 8/9/17
 * Email : pranavjaydev@gmail.com
 */

public interface EndPointApi {

    @POST("members/auth")
    Call<LoginResponse> doLogin(@Body JsonObject profiledata);

    @POST("members/create")
    Call<RegisterResponse> doRegister(@Body JsonObject profiledata);

    @FormUrlEncoded
    @POST("basics")
    Call<BasicDetailsResponse> getBasicDetails(@Field("member_id") String memberId, @Field("app_token") String appTokewn);

    @FormUrlEncoded
    @POST("addresses")
    Call<AddressListResponse> getAddressList(@Field("member_id") String memberId, @Field("app_token") String appToken);

    @FormUrlEncoded
    @POST("achievements")
    Call<AchievementListResponse> getAchievementList(@Field("member_id") String memberId, @Field("app_token") String appToken);


    @FormUrlEncoded
    @POST("businesses")
    Call<BusinessListResponse> getBusiness(@Field("member_id") String memberId, @Field("app_token") String appToken);

    @FormUrlEncoded
    @POST("dharmik")
    Call<DharmikDetailsResponse> getDharmikDetails(@Field("member_id") String memberId, @Field("app_token") String appToken);


    @FormUrlEncoded
    @POST("basics")
    Call<UpdateBasicDetailsResponse> updateBasicDetails(@Field("member_id") String memberId, @Field("app_token") String appToken,
                                                        @Field("method") String method, @Field("salution") String salution,
                                                        @Field("first_name") String first_name, @Field("middle_name") String middle_name,
                                                        @Field("last_name") String last_name, @Field("guardian_type") String guardian_type,
                                                        @Field("guardian_name") String guardian_name, @Field("mother_name") String mother_name,
                                                        @Field("address") String address, @Field("city") String city,
                                                        @Field("pincode") String pincode, @Field("state") String state,
                                                        @Field("country") String country, @Field("mobile") String mobile,
                                                        @Field("alternate_number") String alternate_number, @Field("whatsapp_number") String whatsapp_number,
                                                        @Field("birth_day") String birth_day, @Field("gender") String gender,
                                                        @Field("blood_group") String blood_group, @Field("marital_status") String marital_status,
                                                        @Field("marriage_date") String marriage_date, @Field("child_count") String child_count,
                                                        @Field("email_address") String email_address, @Field("is_head_of_family") String is_head_of_family);

    @FormUrlEncoded
    @POST("add_remove_address")
    Call<AddAddressResponse> addAddress(@Field("member_id") String memberId, @Field("app_token") String appToken,
                                        @Field("method") String method, @Field("address1") String address1,
                                        @Field("address2") String address2, @Field("post") String post,
                                        @Field("district") String district, @Field("city") String city,
                                        @Field("pincode") String pincode, @Field("state") String state,
                                        @Field("country") String country, @Field("address_type") String address_type);

    @FormUrlEncoded
    @POST("add_update_promises")
    Call<UpdatePromiseResponse> updatePromises(@Field("member_id") String memberId, @Field("app_token") String appToken,
                                           @Field("method") String method, @Field("navkar_mantra") String navkar_mantra,
                                           @Field("swadhyay") String swadhyay, @Field("sant_darshan") String sant_darshan,
                                           @Field("samayik") String samayik, @Field("navkarsi") String navkarsi,
                                           @Field("pratikraman") String pratikraman, @Field("chovihar") String chovihar,
                                           @Field("others") String others, @Field("special") String special);
    @FormUrlEncoded
    @POST("add_update_knowledge")
    Call<UpdateKnowledgeResponse> updateKnowledge(@Field("member_id") String memberId, @Field("app_token") String appToken,
                                                 @Field("method") String method, @Field("navkar_mantra") String navkar_mantra,
                                                 @Field("samayik") String samayik, @Field("pratikraman") String pratikraman,
                                                 @Field("bol_thokde") String bol_thokde, @Field("shastra_gyan") String shastra_gyan,
                                                 @Field("vishesh_gyan") String vishesh_gyan);

    @FormUrlEncoded
    @POST("add_remove_achievement")
    Call<AddAchievementResponse> addAchievements(@Field("member_id") String memberId, @Field("app_token") String appToken,
                                                 @Field("method") String method, @Field("achievement_sector") String achievement_sector,
                                                 @Field("achievement_level") String achievement_level, @Field("achievement_type") String achievement_type,
                                                 @Field("achievement_detail") String achievement_detail, @Field("achievement_year") String achievement_year);

    @FormUrlEncoded
    @POST("add_remove_business")
    Call<AddBusinessResponse> addBusiness(@Field("member_id") String memberId, @Field("app_token") String appToken,
                                          @Field("method") String method, @Field("business_type") String business_type,
                                          @Field("business_name") String business_name, @Field("business_role") String business_role,
                                          @Field("business_start_year") String business_start_year);

    @FormUrlEncoded
    @POST("add_remove_address")
    Call<DeleteAddressResponse> removeAddress(@Field("member_id") String memberId,
                                              @Field("app_token") String appToken,
                                              @Field("method") String method,
                                              @Field("address_id") String address_id);

    @FormUrlEncoded
    @POST("password_change")
    Call<PasswordChangeResponse> passwordChange(@Field("member_id") String memberId,
                                                @Field("app_token") String appToken,
                                                @Field("current_password") String currentPassword,
                                                @Field("new_password") String newPassword);

    @FormUrlEncoded
    @POST("add_remove_achievement")
    Call<DeleteAchievementResponse> deleteAchievement(@Field("member_id") String memberId, @Field("app_token") String appToken, @Field("method") String method, @Field("achievement_id") String achievement_id);

    @FormUrlEncoded
    @POST("add_remove_business")
    Call<DeleteBusinessResponse> deleteBusiness(@Field("member_id") String memberId, @Field("app_token") String appToken, @Field("method") String method, @Field("business_id") String achievement_id);



}
