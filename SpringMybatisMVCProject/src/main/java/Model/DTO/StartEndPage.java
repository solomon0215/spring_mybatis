package Model.DTO;

public class StartEndPage {
	Long startRow;
	Long endRow;
	
	public StartEndPage(Long startRow, Long endRow) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public Long getStartRow() {
		return startRow;
	}
	
	public Long getEndRow() {
		return endRow;
	}
	
	
}
