package com.idat.CompraBodega.dto;

public class UsuarioDTOResponse {
	
	private Integer idUsuarioDTO;
	private String usuarioDTO;
	private String passwordDTO;
	private String rolDTO;
	
	public Integer getIdUsuarioDTO() {
		return idUsuarioDTO;
	}
	public void setIdUsuarioDTO(Integer idUsuarioDTO) {
		this.idUsuarioDTO = idUsuarioDTO;
	}
	public String getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(String usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	public String getPasswordDTO() {
		return passwordDTO;
	}
	public void setPasswordDTO(String passwordDTO) {
		this.passwordDTO = passwordDTO;
	}
	public String getRolDTO() {
		return rolDTO;
	}
	public void setRolDTO(String rolDTO) {
		this.rolDTO = rolDTO;
	}

}
