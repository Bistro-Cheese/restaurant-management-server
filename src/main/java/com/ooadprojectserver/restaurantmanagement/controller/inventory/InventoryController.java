package com.ooadprojectserver.restaurantmanagement.controller.inventory;

import com.ooadprojectserver.restaurantmanagement.constant.APIConstant;
import com.ooadprojectserver.restaurantmanagement.constant.MessageConstant;
import com.ooadprojectserver.restaurantmanagement.dto.request.ImportInventoryRequest;
import com.ooadprojectserver.restaurantmanagement.dto.response.APIResponse;
import com.ooadprojectserver.restaurantmanagement.dto.response.MessageResponse;
import com.ooadprojectserver.restaurantmanagement.model.inventory.Inventory;
import com.ooadprojectserver.restaurantmanagement.service.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(APIConstant.INVENTORY)
@PreAuthorize("hasRole('OWNER') or hasRole('MANAGER')")
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping()
    public ResponseEntity<APIResponse<List<Inventory>>> getInventory() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        MessageConstant.GET_INVENTORY_SUCCESS,
                        inventoryService.getInventory()
                )
        );
    }

    @PutMapping(APIConstant.INGREDIENT_ID)
    public ResponseEntity<MessageResponse> importIngredient(
            @PathVariable("ingredient_id") Long ingredientId,
            @RequestBody ImportInventoryRequest request
            ) {
        inventoryService.importIngredient(request, ingredientId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MessageResponse(MessageConstant.IMPORT_INGREDIENT_SUCCESS)
        );
    }
}