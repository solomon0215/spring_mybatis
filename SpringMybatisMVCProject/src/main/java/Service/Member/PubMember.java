package Service.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import Command.MemberCommand;
import Encrypt.Encrypt;
import Model.DTO.MemberDTO;

public class PubMember {
	public static MemberDTO execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setUserEmail(memberCommand.getUserEmail());
		dto.setUserGender(memberCommand.getUserGender());
		dto.setUserId(memberCommand.getUserId());
		dto.setUserName(memberCommand.getUserName());
		dto.setUserPh1(memberCommand.getUserPh1());
		dto.setUserPh2(memberCommand.getUserPh2());
		dto.setUserAddr(memberCommand.getUserAddr());
		dto.setUserPw(Encrypt.getEncryption(
				memberCommand.getUserPw()));
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dt.parse(memberCommand.getUserBirth());
			Timestamp userBirth = new Timestamp(date.getTime());
			dto.setUserBirth(userBirth);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
