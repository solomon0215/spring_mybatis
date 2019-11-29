package Model.DTO;

import Command.Member.ListCommand;

public class StartEndPage {
	Long startRow;
	Long endRow;
	ListCommand listCommand;
	

	public StartEndPage(Long startRow, Long endRow, ListCommand listCommand) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
		this.listCommand = listCommand;
	}

	public Long getStartRow() {
		return startRow;
	}
	
	public ListCommand getListCommand() {
		return listCommand;
	}

	public Long getEndRow() {
		return endRow;
	}
	
	
}
