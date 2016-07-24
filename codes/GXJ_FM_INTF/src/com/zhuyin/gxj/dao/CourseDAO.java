package com.zhuyin.gxj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("courseDAO")
public interface CourseDAO {


    @Options(useCache = true)
    @SelectProvider(type = CourseSQL.class, method = "getNewestSQL")
    public List<Map<String, String>> getNewestList(Map<String, String> params);


    @Options(useCache = true)
    @SelectProvider(type = CourseSQL.class, method = "getHotSQL")
    public List<Map<String, String>> getHotList(Map<String, String> params);


    @Select("SELECT id,name,logo_path as path FROM course_catalog where status=1;")
    public List<Map<String, String>> getCataList();


    @Options(useCache = true)
    @SelectProvider(type = CourseSQL.class, method = "getCourseSQL")
    public List<Map<String, String>> getCourseList(Map<String, String> params);

    @Options(useCache = true)
    @SelectProvider(type = CourseSQL.class, method = "getSearchSQL")
    public List<Map<String, String>> search(Map<String, String> params);

    public class CourseSQL {
        private final static Logger logger = Logger.getLogger(CourseSQL.class);

        public String getSearchSQL(final Map<String, String> params){
            SQL sql = getSelectSQLResult();
            StringBuilder sb = new StringBuilder(sql.toString());
            sb.append("name like '%"+params.get("key")+"%'");
            appendPageSQL(params, sb);
            return sb.toString();
        }

        public String getCourseSQL(final Map<String, String> params) {
            StringBuilder sb = new StringBuilder(
                    "SELECT id,name,content,DATE_FORMAT(create_time,'%Y-%m-%d %H:%i:%s') as create_time,status," +
                            "`describe`,soure,times,icon,shares,collect,age_min,age_max FROM course c, " +
                            "catagory_course_relation cc where c.id=cc.courseId and cc.categoryId=").append(
                    params.get("cataId"));
            appendPageSQL(params, sb);
            return sb.toString();
        }

        public String getHotSQL(final Map<String, String> params) {
            SQL sql = getSelectSQLResult();
            StringBuilder sb = new StringBuilder();
            sb.append("select * from (");
            sb.append(sql.toString());

            appendAgeSQL(params, sb);
            sb.append(" order by times desc limit 30) a ");

            appendPageSQL(params, sb);
            return sb.toString();
        }

        public String getNewestSQL(final Map<String, String> params) {
            SQL sql = getSelectSQLResult();
            StringBuilder sb = new StringBuilder();
            sb.append("select * from (");
            sb.append(sql.toString());

            appendAgeSQL(params, sb);
            sb.append(" order by create_time desc limit 30) a ");

            appendPageSQL(params, sb);
            return sb.toString();
        }


        private void appendAgeSQL(Map<String, String> params, StringBuilder sb) {
            int ageMax = -1;
            int ageMin = -1;
            try {
                if (params.containsKey("maxAge")) {
                    ageMax = Integer.parseInt(params.get("maxAge"));
                }
                if (params.containsKey("minAge")) {
                    ageMin = Integer.parseInt(params.get("minAge"));
                }

            } catch (Exception e) {
                logger.error(params, e);
            }
            if (ageMax != -1.0) {
                sb.append(" and (age_max is null or age_max >=" + ageMax + ")");
            }

            if (ageMin != -1.0) {
                sb.append(" and (age_min is null or age_min <=" + ageMin + ")");
            }
        }

        private void appendPageSQL(Map<String, String> params, StringBuilder sb) {
            int page = 1;
            int pageSize = 10;
            try {
                if (params.containsKey("page")) {
                    page = Integer.parseInt(params.get("page"));
                }
                if (params.containsKey("pageSize")) {
                    pageSize = Integer.parseInt(params.get("pageSize"));
                }
            } catch (Exception e) {
                logger.error(params, e);
            }
            int start = (page - 1) * pageSize;
            sb.append(" LIMIT " + start + "," + pageSize);
        }

        private SQL getSelectSQLResult() {
            return new SQL() {
                {
                    SELECT("id,name,content,DATE_FORMAT(create_time,'%Y-%m-%d %H:%i:%s') as create_time,status," +
                            "`describe`,soure,times,icon,shares," +
                            "collect,age_min,age_max");
                    FROM("course");
                    WHERE("1 = 1");
                }
            };
        }

    }
}
