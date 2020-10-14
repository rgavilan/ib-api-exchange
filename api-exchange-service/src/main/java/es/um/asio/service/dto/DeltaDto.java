package es.um.asio.service.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DeltaDto implements Serializable {
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5181842977756732401L;
	
	
	private String entity;
	
	private String action;
	
	private String property;
	
	private String fromType;
	
	private String toType;
	
	private String toName;
	
	private String type;

	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @return the fromType
	 */
	public String getFromType() {
		return fromType;
	}

	/**
	 * @param fromType the fromType to set
	 */
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	/**
	 * @return the toType
	 */
	public String getToType() {
		return toType;
	}

	/**
	 * @param toType the toType to set
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}

	/**
	 * @return the toName
	 */
	public String getToName() {
		return toName;
	}

	/**
	 * @param toName the toName to set
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
