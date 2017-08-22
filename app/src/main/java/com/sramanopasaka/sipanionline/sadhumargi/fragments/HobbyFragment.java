package com.sramanopasaka.sipanionline.sadhumargi.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.sramanopasaka.sipanionline.sadhumargi.R;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.GUIResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.UpdateHobbiesResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.response.UpdatePromiseResponse;
import com.sramanopasaka.sipanionline.sadhumargi.cms.task.RequestProcessor;
import com.sramanopasaka.sipanionline.sadhumargi.helpers.OfflineData;
import com.sramanopasaka.sipanionline.sadhumargi.listener.DataUpdator;
import com.sramanopasaka.sipanionline.sadhumargi.listener.GUICallback;
import com.sramanopasaka.sipanionline.sadhumargi.model.DharmicData;
import com.sramanopasaka.sipanionline.sadhumargi.model.LoginModel;
import com.sramanopasaka.sipanionline.sadhumargi.model.SanghData;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HobbyFragment extends BaseFragment implements GUICallback, DataUpdator {

    @Bind(R.id.org_planning)
    CheckBox org_planning;

    @Bind(R.id.org_comp_operator)
    CheckBox org_comp_operator;

    @Bind(R.id.org_project_operation)
    CheckBox org_project_operation;

    @Bind(R.id.org_fund_raise)
    CheckBox org_fund_raise;

    @Bind(R.id.org_migration_prg)
    CheckBox org_migration_prg;

    @Bind(R.id.org_oration_trainer)
    CheckBox org_oration_trainer;

    @Bind(R.id.org_management_phones)
    CheckBox org_management_phones;

    @Bind(R.id.rel_medical_service)
    CheckBox rel_medical_service;

    @Bind(R.id.rel_vihar_service)
    CheckBox rel_vihar_service;

    @Bind(R.id.rel_gochary_service)
    CheckBox rel_gochary_service;

    @Bind(R.id.rel_jap_tap_cordination)
    CheckBox rel_jap_tap_cordination;

    @Bind(R.id.rel_swadhyai_service)
    CheckBox rel_swadhyai_service;

    @Bind(R.id.rel_kar_sewa)
    CheckBox rel_kar_sewa;

    @Bind(R.id.rel_shivir_management)
    CheckBox rel_shivir_management;

    @Bind(R.id.rel_writeup)
    CheckBox rel_writeup;

    @Bind(R.id.rel_drawing)
    CheckBox rel_drawing;

    @Bind(R.id.rel_self_learning)
    CheckBox rel_self_learning;

    @Bind(R.id.rel_teaching)
    CheckBox rel_teaching;

    @Bind(R.id.rel_branch)
    CheckBox rel_branch;


    @Bind(R.id.social_human_service)
    CheckBox social_human_service;


    @Bind(R.id.social_education_service)
    CheckBox social_education_service;


    @Bind(R.id.social_medical_service)
    CheckBox social_medical_service;
    @Bind(R.id.social_veg_publicity)
    CheckBox social_veg_publicity;

    @Bind(R.id.social_lit_service)
    CheckBox social_lit_service;

    @Bind(R.id.social_water_kiosk_service)
    CheckBox social_water_kiosk_service;

    @Bind(R.id.social_web_handling)
    CheckBox social_web_handling;


    @Bind(R.id.social_speech)
    CheckBox social_speech;


    @Bind(R.id.social_drug_rehab)
    CheckBox social_drug_rehab;





    private View view = null;

    public static HobbyFragment newInstance() {
        return new HobbyFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_ruchi_fragment, container, false);

        ButterKnife.bind(this, view);
        return view;


    }


  /*  @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            Handler mHandler = new Handler();
            mHandler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (getActivity() != null) {

                        showDataUi();


                    }
                }

            }, 100L);

        }
    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showDataUi();
    }

    private void showDataUi() {
        SanghData dharmicData = OfflineData.getSanghData();
        if (dharmicData != null) {
            if (dharmicData.getHobbies() != null) {

                if (!TextUtils.isEmpty(dharmicData.getHobbies().getOrgPlanning()) && dharmicData.getHobbies().getOrgPlanning().equalsIgnoreCase("1"))
                    org_planning.setChecked(true);
                else
                    org_planning.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getOrgCompOperator()) && dharmicData.getHobbies().getOrgCompOperator().equalsIgnoreCase("1"))
                    org_comp_operator.setChecked(true);
                else
                    org_comp_operator.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getOrgProjectOperation()) && dharmicData.getHobbies().getOrgProjectOperation().equalsIgnoreCase("1"))
                    org_project_operation.setChecked(true);
                else
                    org_project_operation.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getOrgFundRaise()) && dharmicData.getHobbies().getOrgFundRaise().equalsIgnoreCase("1"))
                    org_fund_raise.setChecked(true);
                else
                    org_fund_raise.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getOrgMigrationPrg()) && dharmicData.getHobbies().getOrgMigrationPrg().equalsIgnoreCase("1"))
                    org_migration_prg.setChecked(true);
                else
                    org_migration_prg.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getOrgOrationTrainer()) && dharmicData.getHobbies().getOrgOrationTrainer().equalsIgnoreCase("1"))
                    org_oration_trainer.setChecked(true);
                else
                    org_oration_trainer.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getOrgManagementPhones()) && dharmicData.getHobbies().getOrgManagementPhones().equalsIgnoreCase("1"))
                    org_management_phones.setChecked(true);
                else
                    org_management_phones.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelMedicalService()) && dharmicData.getHobbies().getRelMedicalService().equalsIgnoreCase("1"))
                    rel_medical_service.setChecked(true);
                else
                    rel_medical_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelViharService()) && dharmicData.getHobbies().getRelViharService().equalsIgnoreCase("1"))
                    rel_vihar_service.setChecked(true);
                else
                    rel_vihar_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelGocharyService()) && dharmicData.getHobbies().getRelGocharyService().equalsIgnoreCase("1"))
                    rel_gochary_service.setChecked(true);
                else
                    rel_gochary_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelJapTapCordination()) && dharmicData.getHobbies().getRelJapTapCordination().equalsIgnoreCase("1"))
                    rel_jap_tap_cordination.setChecked(true);
                else
                    rel_jap_tap_cordination.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelSwadhyaiService()) && dharmicData.getHobbies().getRelSwadhyaiService().equalsIgnoreCase("1"))
                    rel_swadhyai_service.setChecked(true);
                else
                    rel_swadhyai_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelKarSewa()) && dharmicData.getHobbies().getRelKarSewa().equalsIgnoreCase("1"))
                    rel_kar_sewa.setChecked(true);
                else
                    rel_kar_sewa.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelShivirManagement()) && dharmicData.getHobbies().getRelShivirManagement().equalsIgnoreCase("1"))
                    rel_shivir_management.setChecked(true);
                else
                    rel_shivir_management.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelWriteup()) && dharmicData.getHobbies().getRelWriteup().equalsIgnoreCase("1"))
                    rel_writeup.setChecked(true);
                else
                    rel_writeup.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelDrawing()) && dharmicData.getHobbies().getRelDrawing().equalsIgnoreCase("1"))
                    rel_drawing.setChecked(true);
                else
                    rel_drawing.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelSelfLearning()) && dharmicData.getHobbies().getRelSelfLearning().equalsIgnoreCase("1"))
                    rel_self_learning.setChecked(true);
                else
                    rel_self_learning.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelTeaching()) && dharmicData.getHobbies().getRelTeaching().equalsIgnoreCase("1"))
                    rel_teaching.setChecked(true);
                else
                    rel_teaching.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getRelBranch()) && dharmicData.getHobbies().getRelBranch().equalsIgnoreCase("1"))
                    rel_branch.setChecked(true);
                else
                    rel_branch.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialHumanService()) && dharmicData.getHobbies().getSocialHumanService().equalsIgnoreCase("1"))
                    social_human_service.setChecked(true);
                else
                    social_human_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialEducationService()) && dharmicData.getHobbies().getSocialEducationService().equalsIgnoreCase("1"))
                    social_education_service.setChecked(true);
                else
                    social_education_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialMedicalService()) && dharmicData.getHobbies().getSocialMedicalService().equalsIgnoreCase("1"))
                    social_medical_service.setChecked(true);
                else
                    social_medical_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialVegPublicity()) && dharmicData.getHobbies().getSocialVegPublicity().equalsIgnoreCase("1"))
                    social_veg_publicity.setChecked(true);
                else
                    social_veg_publicity.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialLitService()) && dharmicData.getHobbies().getSocialLitService().equalsIgnoreCase("1"))
                    social_lit_service.setChecked(true);
                else
                    social_lit_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialWaterKioskService()) && dharmicData.getHobbies().getSocialWaterKioskService().equalsIgnoreCase("1"))
                    social_water_kiosk_service.setChecked(true);
                else
                    social_water_kiosk_service.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialWebHandling()) && dharmicData.getHobbies().getSocialWebHandling().equalsIgnoreCase("1"))
                    social_web_handling.setChecked(true);
                else
                    social_web_handling.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialSpeech()) && dharmicData.getHobbies().getSocialSpeech().equalsIgnoreCase("1"))
                    social_speech.setChecked(true);
                else
                    social_speech.setChecked(false);
                if (!TextUtils.isEmpty(dharmicData.getHobbies().getSocialDrugRehab()) && dharmicData.getHobbies().getSocialDrugRehab().equalsIgnoreCase("1"))
                    social_drug_rehab.setChecked(true);
                else
                    social_drug_rehab.setChecked(false);
            }
        }
    }

    @OnClick(R.id.updateHobby)
    public void updateHobby() {

        LoginModel loginResponse = OfflineData.getLoginData();
        if (loginResponse != null) {
            showLoadingDialog();

            RequestProcessor requestProcessor = new RequestProcessor(HobbyFragment.this);
            requestProcessor.updateHobbies(loginResponse.getId(), loginResponse.getAppToken(), String.valueOf(org_planning.isChecked()), String.valueOf(org_comp_operator.isChecked()),
                    String.valueOf(org_project_operation.isChecked()), String.valueOf(org_fund_raise.isChecked()), String.valueOf(org_migration_prg.isChecked()),
                    String.valueOf(org_oration_trainer.isChecked()), String.valueOf(org_management_phones.isChecked()), String.valueOf(rel_medical_service.isChecked()),
                   String.valueOf(rel_vihar_service.isChecked()),String.valueOf(rel_gochary_service.isChecked()),String.valueOf(rel_jap_tap_cordination.isChecked()),
                           String.valueOf(rel_swadhyai_service.isChecked()), String.valueOf(rel_kar_sewa.isChecked()),String.valueOf(rel_shivir_management.isChecked()),
                                   String.valueOf(rel_writeup.isChecked()),String.valueOf(rel_drawing.isChecked()),String.valueOf(rel_self_learning.isChecked()),
                                           String.valueOf(rel_teaching.isChecked()),String.valueOf(rel_branch.isChecked()),String.valueOf(social_human_service.isChecked()),
                                                   String.valueOf(social_education_service.isChecked()),String.valueOf(social_medical_service.isChecked()),
                                                           String.valueOf(social_veg_publicity.isChecked()),String.valueOf(social_lit_service.isChecked()),
                                                                   String.valueOf(social_water_kiosk_service.isChecked()),String.valueOf(social_web_handling.isChecked()),
                                                                           String.valueOf(social_speech.isChecked()), String.valueOf(social_drug_rehab.isChecked()));
        }


    }

    @Override
    public void onRequestProcessed(GUIResponse guiResponse, RequestStatus requestStatus) {
        hideLoadingDialog();
        if (guiResponse != null) {
            if (requestStatus.equals(RequestStatus.SUCCESS)) {
                if (guiResponse instanceof UpdateHobbiesResponse) {
                    UpdateHobbiesResponse response = (UpdateHobbiesResponse) guiResponse;
                    if (response != null) {
                        if (!TextUtils.isEmpty(response.getStatus()) && response.getStatus().equalsIgnoreCase("success")) {

                            /*if (dharmikActivity == null)
                                dharmikActivity = (DharmikActivity) getActivity();
                            dharmikActivity.loadDharmikData();
*/
                            if (!TextUtils.isEmpty(response.getMessage())) {
                                Toast.makeText(getActivity(), response.getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "Updated successfully", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            if (!TextUtils.isEmpty(response.getMessage())) {
                                Toast.makeText(getActivity(), response.getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(getActivity(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDataRefreshed() {
        showDataUi();
    }
}
