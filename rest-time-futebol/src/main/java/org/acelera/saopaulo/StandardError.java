package org.acelera.saopaulo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author andre
 */
public final class StandardError implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	private StandardError(Long timestamp, Integer status, String error, String message, String path)
	{
		super();
		this.setTimestamp(timestamp);
		this.setStatus(status);
		this.setError(error);
		this.setMessage(message);
		this.setPath(path);
	}

	public static StandardErrorBuilder builder()
	{
		return new StandardErrorBuilder();
	}

	public Long getTimestamp()
	{
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp)
	{
		Objects.requireNonNull(timestamp, "timestamp must not be null");
		this.timestamp = timestamp;
	}

	public Integer getStatus()
	{
		return this.status;
	}

	public void setStatus(Integer status)
	{
		Objects.requireNonNull(status, "status must not be null");
		this.status = status;
	}

	public String getError()
	{
		return this.error;
	}

	public void setError(String error)
	{
		Objects.requireNonNull(error, "error must not be null");
		this.error = error;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(String message)
	{
		Objects.requireNonNull(message, "message must not be null");
		this.message = message;
	}

	public String getPath()
	{
		return this.path;
	}

	public void setPath(String path)
	{
		Objects.requireNonNull(path, "path must not be null");
		this.path = path;
	}

	public static final class StandardErrorBuilder
	{
		private Long timestamp;
		private Integer status;
		private String error;
		private String message;
		private String path;

		public StandardErrorBuilder timestamp(Long timestamp)
		{
			this.timestamp = timestamp;
			return this;
		}

		public StandardErrorBuilder status(Integer status)
		{
			this.status = status;
			return this;
		}

		public StandardErrorBuilder error(String error)
		{
			this.error = error;
			return this;
		}

		public StandardErrorBuilder message(String message)
		{
			this.message = message;
			return this;
		}

		public StandardErrorBuilder path(String path)
		{
			this.path = path;
			return this;
		}

		public StandardError build()
		{
			return new StandardError(timestamp, status, error, message, path);
		}
	}
}
