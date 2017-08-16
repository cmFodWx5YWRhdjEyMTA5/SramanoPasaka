package com.sramanopasaka.sipanionline.sadhumargi.cms.task;

import android.util.Log;

import com.google.gson.JsonObject;
import com.sramanopasaka.sipanionline.sadhumargi.AppConstants;
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
import com.sramanopasaka.sipanionline.sadhumargi.listener.EndPointApi;
import com.sramanopasaka.sipanionline.sadhumargi.listener.GUICallback;
import com.sramanopasaka.sipanionline.sadhumargi.model.Achievements;
import com.sramanopasaka.sipanionline.sadhumargi.model.Address;
import com.sramanopasaka.sipanionline.sadhumargi.model.BasicDetailsData;
import com.sramanopasaka.sipanionline.sadhumargi.model.Business;
import com.sramanopasaka.sipanionline.sadhumargi.model.Promise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

/**
 * Name    :   pranavjdev
 * Date   : 8/9/17
 * Email : pranavjaydev@gmail.com
 */

public class RequestProcessor {
    private GUICallback guiCallback = null;

    public RequestProcessor(GUICallback guiCallback) {
        this.guiCallback = guiCallback;

    }

    public void doLogin(JsonObject jsonObject) {


        EndPointApi endPointApi = RetrofitClient.getAuthClient().create(EndPointApi.class);

        endPointApi.doLogin(jsonObject).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                Log.e("Response message=", "" + response.message());

               /* LoginResponse response1 = new LoginResponse();
                if (response.body() != null) {
                    response1.setLoginModel(response.body());

                    response1.setStatus(true);

                } else {
                    response1.setStatus(false);
                    if (!TextUtils.isEmpty(response.errorBody().toString())) {
                        try {
                            JSONObject jObjError = new JSONObject(convertStreamToString(response.errorBody().byteStream()));
                            response1.setMessage(jObjError.getString("message"));
                        } catch (Exception e) {
                            response1.setMessage("Invalid Username or Password");
                        }
                    } else {
                        response1.setMessage("Invalid Username or Password");

                    }


                }*/

                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void doRegister(JsonObject jsonObject) {


        EndPointApi endPointApi = RetrofitClient.getAuthClient().create(EndPointApi.class);

        endPointApi.doRegister(jsonObject).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {


                Log.e("Response message=", "" + response.message());

               /* LoginResponse response1 = new LoginResponse();
                if (response.body() != null) {
                    response1.setLoginModel(response.body());

                    response1.setStatus(true);

                } else {
                    response1.setStatus(false);
                    if (!TextUtils.isEmpty(response.errorBody().toString())) {
                        try {
                            JSONObject jObjError = new JSONObject(convertStreamToString(response.errorBody().byteStream()));
                            response1.setMessage(jObjError.getString("message"));
                        } catch (Exception e) {
                            response1.setMessage("Invalid Username or Password");
                        }
                    } else {
                        response1.setMessage("Invalid Username or Password");

                    }


                }*/

                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void getBasicDetails(String memberId, String token) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);

        endPointApi.getBasicDetails(memberId, token).enqueue(new Callback<BasicDetailsResponse>() {
            @Override
            public void onResponse(Call<BasicDetailsResponse> call, Response<BasicDetailsResponse> response) {


                Log.e("Response message=", "" + response.message());

               /* LoginResponse response1 = new LoginResponse();
                if (response.body() != null) {
                    response1.setLoginModel(response.body());

                    response1.setStatus(true);

                } else {
                    response1.setStatus(false);
                    if (!TextUtils.isEmpty(response.errorBody().toString())) {
                        try {
                            JSONObject jObjError = new JSONObject(convertStreamToString(response.errorBody().byteStream()));
                            response1.setMessage(jObjError.getString("message"));
                        } catch (Exception e) {
                            response1.setMessage("Invalid Username or Password");
                        }
                    } else {
                        response1.setMessage("Invalid Username or Password");

                    }


                }*/

                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<BasicDetailsResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void getAddressList(String memberId, String token) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);

        endPointApi.getAddressList(memberId, token).enqueue(new Callback<AddressListResponse>() {
            @Override
            public void onResponse(Call<AddressListResponse> call, Response<AddressListResponse> response) {


                Log.e("Response message=", "" + response.message());
                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<AddressListResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void getAchievementList(String memberId, String token) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);

        endPointApi.getAchievementList(memberId, token).enqueue(new Callback<AchievementListResponse>() {
            @Override
            public void onResponse(Call<AchievementListResponse> call, Response<AchievementListResponse> response) {


                Log.e("Response message=", "" + response.message());
                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<AchievementListResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void getBusnessList(String memberId, String token) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);

        endPointApi.getBusiness(memberId, token).enqueue(new Callback<BusinessListResponse>() {
            @Override
            public void onResponse(Call<BusinessListResponse> call, Response<BusinessListResponse> response) {


                Log.e("Response message=", "" + response.message());
                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<BusinessListResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void getDharmikDetails(String memberId, String token) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);

        endPointApi.getDharmikDetails(memberId, token).enqueue(new Callback<DharmikDetailsResponse>() {
            @Override
            public void onResponse(Call<DharmikDetailsResponse> call, Response<DharmikDetailsResponse> response) {


                Log.e("Response message=", "" + response.message());
                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<DharmikDetailsResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void updateBasicDetails(String memberId, String token, BasicDetailsData data) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.updateBasicDetails(memberId, token, "update", data.getSalution(), data.getFirstName(), data.getMiddleName(), data.getLastName(),
                data.getGuardianType(), data.getGuardianName(), data.getMotherName(), data.getAddress(), data.getCity(), data.getPincode(), data.getState(), data.getCountry(), data.getMobile(), data.getAlternateNumber(),
                data.getWhatsappNumber(), data.getBirthDay(), data.getGender(), data.getBloodGroup(), data.getMaritalStatus(), data.getMarriageDate(), data.getChildCount(), data.getEmailAddress(), data.getIsHeadOfFamily()).enqueue(new Callback<UpdateBasicDetailsResponse>() {
            @Override
            public void onResponse(Call<UpdateBasicDetailsResponse> call, Response<UpdateBasicDetailsResponse> response) {


                Log.e("Response message=", "" + response.message());

               /* LoginResponse response1 = new LoginResponse();
                if (response.body() != null) {
                    response1.setLoginModel(response.body());

                    response1.setStatus(true);

                } else {
                    response1.setStatus(false);
                    if (!TextUtils.isEmpty(response.errorBody().toString())) {
                        try {
                            JSONObject jObjError = new JSONObject(convertStreamToString(response.errorBody().byteStream()));
                            response1.setMessage(jObjError.getString("message"));
                        } catch (Exception e) {
                            response1.setMessage("Invalid Username or Password");
                        }
                    } else {
                        response1.setMessage("Invalid Username or Password");

                    }


                }*/

                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<UpdateBasicDetailsResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void addAddress(String memberId, String token, Address data) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.addAddress(memberId, token, "add", data.getAddress1(), data.getAddress2(), data.getPost(), data.getDistrict(),
                data.getCity(), data.getPincode(), data.getState(), data.getCountry(), data.getAddress_type()).enqueue(new Callback<AddAddressResponse>() {
            @Override
            public void onResponse(Call<AddAddressResponse> call, Response<AddAddressResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<AddAddressResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void updatePromises(String memberId, String token, String navkar_mantra,
                               String swadhyay, String sant_darshan,
                               String samayik, String navkarsi,
                               String pratikraman, String chovihar,
                               String others, String special) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.updatePromises(memberId, token, "update", navkar_mantra, swadhyay, sant_darshan, samayik,
                navkarsi, pratikraman, chovihar, others, special).enqueue(new Callback<UpdatePromiseResponse>() {
            @Override
            public void onResponse(Call<UpdatePromiseResponse> call, Response<UpdatePromiseResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<UpdatePromiseResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void updateKnowledge(String memberId, String token, String navkar_mantra,
                               String samayik, String pratikraman,
                                String bol_thokde,  String shastra_gyan,
                                String vishesh_gyan) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.updateKnowledge(memberId, token, "update", navkar_mantra, samayik, pratikraman, bol_thokde,
                shastra_gyan, vishesh_gyan).enqueue(new Callback<UpdateKnowledgeResponse>() {
            @Override
            public void onResponse(Call<UpdateKnowledgeResponse> call, Response<UpdateKnowledgeResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<UpdateKnowledgeResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }


    public void addAchievemetns(String memberId, String token, Achievements data) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.addAchievements(memberId, token, "add", data.getAchievement_sector(), data.getAchievement_level(), data.getAchievement_type(), data.getAchievement_detail(),
                data.getAchievement_year()).enqueue(new Callback<AddAchievementResponse>() {
            @Override
            public void onResponse(Call<AddAchievementResponse> call, Response<AddAchievementResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<AddAchievementResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void addBusiness(String memberId, String token, Business data) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.addBusiness(memberId, token, "add", data.getBusiness_type(), data.getBusiness_name(), data.getBusiness_role(), data.getBusiness_start_year()).enqueue(new Callback<AddBusinessResponse>() {
            @Override
            public void onResponse(Call<AddBusinessResponse> call, Response<AddBusinessResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<AddBusinessResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void removeAddress(String memberId, String token, Address data) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.removeAddress(memberId, token, "delete", data.getId()).enqueue(new Callback<DeleteAddressResponse>() {
            @Override
            public void onResponse(Call<DeleteAddressResponse> call, Response<DeleteAddressResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<DeleteAddressResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void removeAchievements(String memberId, String token, Achievements data) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.deleteAchievement(memberId, token, "delete", data.getId()).enqueue(new Callback<DeleteAchievementResponse>() {
            @Override
            public void onResponse(Call<DeleteAchievementResponse> call, Response<DeleteAchievementResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<DeleteAchievementResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public void removeBusiness(String memberId, String token, Business data) {


        EndPointApi endPointApi = RetrofitClient.getMemberClient().create(EndPointApi.class);


        endPointApi.deleteBusiness(memberId, token, "delete", data.getId()).enqueue(new Callback<DeleteBusinessResponse>() {
            @Override
            public void onResponse(Call<DeleteBusinessResponse> call, Response<DeleteBusinessResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<DeleteBusinessResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });

    }

    public void passwordChange(String memberId, String token, String currentPassword, String newPassword) {


        EndPointApi valYouAPI = RetrofitClient.getMemberClient().create(EndPointApi.class);


        valYouAPI.passwordChange(memberId, token, currentPassword, newPassword).enqueue(new Callback<PasswordChangeResponse>() {
            @Override
            public void onResponse(Call<PasswordChangeResponse> call, Response<PasswordChangeResponse> response) {


                Log.e("Response message=", "" + response.message());


                if (response.body() != null)
                    guiCallback.onRequestProcessed(response.body(), GUICallback.RequestStatus.SUCCESS);
                else
                    guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);

            }

            @Override
            public void onFailure(Call<PasswordChangeResponse> call, Throwable t) {


                guiCallback.onRequestProcessed(null, GUICallback.RequestStatus.FAILED);
            }
        });


    }

    public String convertStreamToString(InputStream inputStream) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        }

        String finallyError = sb.toString();
        Log.e("finallyError=", "" + finallyError);
        return finallyError;
    }
}
