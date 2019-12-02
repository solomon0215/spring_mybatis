package Model.DTO;

import Command.ListCommand;

public class StartEndPageDTO {
	Long startRow;
	Long endRow;
	ListCommand listCommand;

	public StartEndPageDTO(Long startRow, Long endRow, 
			ListCommand listCommand) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
		this.listCommand = listCommand;
	}
	public ListCommand getListCommand() {
		return listCommand;
	}

	public Long getStartRow() {
		return startRow;
	}

	public Long getEndRow() {
		return endRow;
	}

}
