package hpe.lxc.spring.tx_one;

public class BookStockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4338087333322715548L;

	public BookStockException() {
		super();
	}

	public BookStockException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookStockException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookStockException(String message) {
		super(message);
	}

	public BookStockException(Throwable cause) {
		super(cause);
	}

}
