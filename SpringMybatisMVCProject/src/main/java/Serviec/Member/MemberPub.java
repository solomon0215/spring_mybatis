package Serviec.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import Command.Member.MemberCommand;
import Encrypt.Encrypt;
import Model.DTO.MemberDTO;

public class MemberPub {
	public static MemberDTO execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		try {
			dto.setUserAddr(memberCommand.getUserAddr());
			SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
			Date date = dt.parse(memberCommand.getUserBirth());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
			Timestamp userBirth = new Timestamp(date.getTime());
			dto.setUserBirth(userBirth);
			dto.setUserEmail(memberCommand.getUserEmail());
			dto.setUserGender(memberCommand.getUserGender());
			dto.setUserId(memberCommand.getUserId());
			dto.setUserName(memberCommand.getUserName());
			dto.setUserPh1(memberCommand.getUserPh1());
			dto.setUserPh2(memberCommand.getUserPh2());
			dto.setUserPw(
					Encrypt.getEncryption(memberCommand.getUserPw()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
