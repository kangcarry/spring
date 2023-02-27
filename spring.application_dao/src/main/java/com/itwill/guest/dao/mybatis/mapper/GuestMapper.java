package com.itwill.guest.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itwill.guest.dao.mybatis.Guest;

@Mapper
public interface GuestMapper {
	@Select("select guest_no,guest_name,guest_date,guest_email,guest_homepage from guest")
	public List<Guest> selectAll();
	@Select("select guest_no,guest_name,guest_date,guest_email,guest_homepage from guest where guest_no = #{no}")
	public Guest selectByNo(int no);
}