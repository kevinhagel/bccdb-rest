package com.bccdb.rest.dto;

import com.bccdb.rest.model.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * SchoolDto is a dto transferring {@link School} information to the rest client.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
  private String id;
  private String name;
  private List<String> contacts;
  private String contactName;
  private String contactPhone;
  private String addressStreet;
  private String addressCity;
  private String notes;
  private List<String> defaultClassesList = new ArrayList<>();
}
