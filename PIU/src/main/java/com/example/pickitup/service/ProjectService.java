package com.example.pickitup.service;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewFileDAO;
import com.example.pickitup.domain.dao.user.ApplyDAO;
import com.example.pickitup.domain.dao.user.JjimDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.ProjectCriteria;
import com.example.pickitup.domain.vo.dto.ProjectDTO;
import com.example.pickitup.domain.vo.dto.ProjectMainDTO;
import com.example.pickitup.domain.vo.dto.ReviewDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectDAO projectDAO;
    private final ProjectQnaDAO projectQnaDAO;
    private final ProjectQnaCommentDAO projectQnaCommentDAO;
    private final JjimDAO jjimDAO;
    private final ApplyDAO applyDAO;
    private final ProjectReviewDAO projectReviewDAO;
    private final ProjectReviewFileDAO projectReviewFileDAO;
    private final ProjectFileDAO projectFileDAO;

    // ???????????? ??????(????????????)
    public List<ProjectVO> getList(){
        return projectDAO.getList();
    }


    // ???????????? ??????(??????)
    public List<ProjectMainDTO> getListTotalSearch() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getList();

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getStartTime();  // ?????? ?????? ????????? (("yyyy-MM-dd")??? ??????)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // ????????????

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "???????????????!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
        }
        return projectMainDTOS;
    }

    // QR?????? (????????????)
    public boolean insertQr(Long qrNum, String projectLink1,String projectLink2 ){
        return projectDAO.insertQr(qrNum,projectLink1,projectLink2);
    }

    // ???????????? ???????????? ?????? ??????
    public List<ProjectDTO> getProjectList(ProjectCriteria projectCriteria){
        return projectDAO.getProjectList(projectCriteria);
    }

    public List<ProjectDTO> getListToday(String startDate,String endDate){
        return projectDAO.getListToday(startDate,endDate);
    }

    public int getProjectTotal(ProjectCriteria projectCriteria){
        return projectDAO.getProjectTotal(projectCriteria);
    }


    // ???????????? ??????(?????? ?????? ??????)
    public List<ProjectVO> getUserProjectList(Long companyNum, Criteria criteria){
        return projectDAO.getUserProjectList(companyNum, criteria);
    }


    // ???????????? ?????? ???????????? ??????
    public int getUserProjectTotal(Long companyNum){
        return projectDAO.getUserProjectTotal(companyNum);
    }

    // ???????????? ????????????
    public ProjectVO read(Long num){
        return projectDAO.read(num);
    }

    // ???????????? ??????

    public List<ProjectFileVO> getList1(Long num) {
        return projectFileDAO.findByProjectNum(num);
    }

    // ????????? ??????????????? ?????? ?????? DML??? ?????? ?????? ??? ????????? ?????? ??? ?????? ROLLBACK
    @Transactional(rollbackFor = Exception.class)
    public void registerProject (ProjectVO projectVO) {
        //????????? ??????
        log.info("fileList" + projectVO.getFileList());
        projectDAO.register(projectVO);
        log.info("????????????1=======");
        //???????????? ???????????? ???????????? ?????? ??? ????????? ????????? ?????? ??????
        if(projectVO.getFileList() != null) {
            log.info("????????????==============");
            projectVO.getFileList().forEach(projectFileVO -> {
                log.info("???????????? ?????? : " + projectVO.getNum());
                projectFileVO.setProjectNum(projectVO.getNum() + 1l);
                projectFileDAO.register(projectFileVO);
            });
        }
    }


    // ???????????? ??????
    public boolean update(ProjectVO projectVO){
        return projectDAO.update(projectVO);
    }

    // ???????????? ??????
    public boolean remove(Long num){
        return projectDAO.remove(num);
    }

    // ???????????? ?????? ????????????
    public List<ProjectFileVO>getProjectFileList(Long num){
        return projectFileDAO.findByProjectNum(num);
    }

    // QnA ??????
    public void registerQnA(ProjectQnaVO projectQnaVO){
        projectQnaDAO.register(projectQnaVO);
    }

    // QnA ??????
    public List<ProjectQnaVO> getQnAList(Long projectNum){
        return projectQnaDAO.getList(projectNum);
    }

    // QnA ?????? ??????
    public List<ProjectQnaCommentVO> getCommentList(Long qnaNum){
        return projectQnaCommentDAO.getComment(qnaNum);
    }

    // ??? ??????
    @Transactional(rollbackFor = Exception.class)
    public void addJjim(JjimVO jjimVO){
        jjimDAO.myProjectJjimInsert(jjimVO);
        projectDAO.jjimPlus(jjimVO.getProjectNum());
    }

    // ??? ??????
    @Transactional(rollbackFor = Exception.class)
    public void removeJjim(JjimVO jjimVO){
        jjimDAO.myProjectJjimDelete( jjimVO);
        projectDAO.jjimMinus(jjimVO.getProjectNum());
    }

    // ???????????? ??????
    public void apply(ApplyVO applyVO){
        applyDAO.register(applyVO);
    }

    // ?????? ??????
    @Transactional(rollbackFor = Exception.class)
    public void registerReview(ProjectReviewVO projectReviewVO) {
        //????????? ??????
        projectReviewDAO.register(projectReviewVO);
        //???????????? ???????????? ???????????? ?????? ??? ????????? ????????? ?????? ??????
        if (projectReviewVO.getFileList() != null) {
            projectReviewVO.getFileList().forEach(projectReviewFileVO -> {
//                projectReviewFileVO.setProjectNum(boardVO.getBoardBno());
                projectReviewFileVO.setProjectReviewNum(34L);
                projectReviewFileDAO.register(projectReviewFileVO);
            });
        }
    }

    // ?????? ??????
    @Transactional(rollbackFor = Exception.class)
    public void modifyReview(ProjectReviewVO projectReviewVO) {
        // ?????? ?????? ??????
        projectReviewFileDAO.remove(projectReviewVO.getNum());

        // ?????? ??????
        if (projectReviewVO.getFileList() != null) {
            projectReviewVO.getFileList().forEach(projectReviewFileVO -> {
                projectReviewFileVO.setProjectReviewNum(projectReviewVO.getNum());
                projectReviewFileDAO.register(projectReviewFileVO);
            });
        }

        // ????????? ??????
        projectReviewDAO.update(projectReviewVO);
    }

    // ?????? ?????? ????????????
    public List<ProjectReviewFileVO>getReviewFileList(Long num){
        return projectReviewFileDAO.findProjectReviewNum(num);
    }

    // ?????? ?????? ????????????(?????????)
    public ReviewDTO readReview(Long reviewNum){
        return projectReviewDAO.readReview(reviewNum);
    }

    // ?????? ??????
    public void removeReview(Long reviewNum){
        projectReviewDAO.remove(reviewNum);
    }

    // ?????? ??????
    public List<ReviewDTO> getProjectReviewList(Long projectNum){
        return projectReviewDAO.getReviewList(projectNum);
    }


    @Transactional
    public boolean setApproval(Long projectNum, Long applyNum){
        applyDAO.setApproachToContinue(applyNum);
        return projectDAO.setApprovaltoContinue(projectNum);
    }


    // ???????????? ??????(??????)
    public List<ProjectMainDTO> getListJJim() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListJJim();

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getStartTime();  // ?????? ?????? ????????? (("yyyy-MM-dd")??? ??????)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // ????????????

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "???????????????!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
        }
        return projectMainDTOS;
    }
    // ???????????? ??????(????????????)
    public List<ProjectMainDTO> getListPoint() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListPoint();

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getStartTime();  // ?????? ?????? ????????? (("yyyy-MM-dd")??? ??????)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // ????????????

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "???????????????!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));


        }
        return projectMainDTOS;
    }
    // ???????????? ??????(????????????)
    public List<ProjectMainDTO> getListApply() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListApply();


        for(ProjectVO pp : projectVOS){
            String strDate = pp.getStartTime();  // ?????? ?????? ????????? (("yyyy-MM-dd")??? ??????)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // ????????????

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "???????????????!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));


        }
        return projectMainDTOS;
    }

    public List<ProjectMainDTO> getListCourse(String course) throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListCourse(course);

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getStartTime();  // ?????? ?????? ????????? (("yyyy-MM-dd")??? ??????)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // ????????????

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "???????????????!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
        }

        return projectMainDTOS;
    }

    public List<ProjectMainDTO> getListAll() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListAll();

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getStartTime();  // ?????? ?????? ????????? (("yyyy-MM-dd")??? ??????)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // ????????????
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());
            long calculate = date.getTime() - today.getTime();
            int Ddays = (int) (calculate / ( 24*60*60*1000));
            String Ddate ="";
            if(Ddays==0){
                Ddate = "???????????????!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
        }
        return projectMainDTOS;
    }


    public List<ProjectVO> getSearchList(String searchStr){
        return projectDAO.getSearchList(searchStr);
    }

    // ???????????? ???????????? ??????
    public List<ProjectMainDTO> getListTerrain(String terrain) throws ParseException{


        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListTerrain(terrain);

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getStartTime();  // ?????? ?????? ????????? (("yyyy-MM-dd")??? ??????)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // ????????????
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());
            long calculate = date.getTime() - today.getTime();
            int Ddays = (int) (calculate / ( 24*60*60*1000));
            String Ddate ="";
            if(Ddays==0){
                Ddate = "???????????????!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
        }

        return projectMainDTOS;
    }


    // ??? ??????
    public int jjimCount(Long projectNum){
        return jjimDAO.myProjectJjimCount(projectNum);
    }

    //??? ??????
    public void jjimPlus(Long projectNum){
        projectDAO.jjimPlus(projectNum);
    }
    //??? ????????????
    public void jjimMinus(Long projectNum){
        projectDAO.jjimMinus(projectNum);
    }

}
