package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.response.AuthenticationResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.RoleMenu;
import com.conurets.parking_kiosk.security.model.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class AuthenticationMapper extends BaseMapper {

//    MenuMapper menuMapper;
//    MenuPrivilegeMapper menuPrivilegeMapper;
//    @Autowired
//    AuthenticationMapper(MenuMapper menuMapper, MenuPrivilegeMapper menuPrivilegeMapper){
//        this.menuMapper = menuMapper;
//        this.menuPrivilegeMapper = menuPrivilegeMapper;
//    }
    /**
     * authenticate
     *
     * @param customUserDetails
     * @param accessToken
     * @return AuthenticationResponseDTO
     * @throws PKException
     */
    public AuthenticationResponseDTO authenticate(CustomUserDetails customUserDetails, List<RoleMenu> roleMenu, String accessToken) throws PKException {
        AuthenticationResponseDTO dto = new AuthenticationResponseDTO();
        dto.setDisplayName(customUserDetails.getDisplayName());
        dto.setAccessToken(accessToken);
        dto.setUserId(customUserDetails.getUserId());
        dto.setRole(customUserDetails.getRole());
        dto.setUserTypeName(customUserDetails.getUserType());
        dto.setUserTypeId(customUserDetails.getUserTypeId());
//        List<MenuResponseDTO> menuResponseDTOList = roleMenu.stream()
//                .map(menuPrivilege -> this.menuMapper.find(menuPrivilege.getMenu()))
//                .filter(menuResponseDTO -> menuResponseDTO != null)
//                .collect(Collectors.toList());
//        dto.setMenus(menuResponseDTOList);
        return dto;
    }
}
