package com.zhuyin.gxj.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

public interface CourseDAO {

	@Options(useCache=true)
	@SelectProvider(type=CourseSQL.class,method="getNewestSQL")
	public Map<String, String> getNewestList(Map<String, String> params);

	public class CourseSQL {
		public String getNewestSQL(final Map<String, String> params) {
			SQL sql = getSelectSQLResult();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from (");
			sb.append(sql.toString());

			int page = 1;
			int pageSize = 10;
			int ageMax = -1;
			int ageMin = -1;
			try {
				if (params.containsKey("page")) {
					page = Integer.parseInt(params.get("page"));
				}
				if (params.containsKey("pageSize")) {
					pageSize = Integer.parseInt(params.get("pageSize"));
				}
				if (params.containsKey("ageMax")) {
					ageMax = Integer.parseInt(params.get("ageMax"));
				}
				if (params.containsKey("ageMin")) {
					ageMin = Integer.parseInt(params.get("ageMin"));
				}

			} catch (Exception e) {

			}
			if(ageMax!=-1){
				sb.append(" and (age_max is null or age_max >="+ageMax+")");
			}

			if(ageMin!=-1){
				sb.append(" and (age_min is null or age_min <="+ageMin+")");
			}
			sb.append(" order by create_time desc limit 30) a ");
			int start = (page - 1) * pageSize;
			sb.append(" LIMIT "+start+","+pageSize);
			return sb.toString();
		}

		private SQL getSelectSQLResult() {
			return new SQL() {
				{
					SELECT("id,name,content,create_time,status,describe,soure,times,icon,age,shares,collect");
					FROM("course");
					WHERE("1 = 1");
				}
			};
		}

	}
}
