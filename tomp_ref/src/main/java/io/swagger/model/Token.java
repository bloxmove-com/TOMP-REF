package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to show their right to travel, or use to access an asset
 */
@Schema(description = "The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to show their right to travel, or use to access an asset")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class Token   {
  @JsonProperty("validFrom")
  private OffsetDateTime validFrom = null;

  @JsonProperty("validUntil")
  private OffsetDateTime validUntil = null;

  @JsonProperty("tokenType")
  private String tokenType = null;

  @JsonProperty("tokenData")
  @Valid
  private Map<String, Object> tokenData = new HashMap<String, Object>();

  public Token validFrom(OffsetDateTime validFrom) {
    this.validFrom = validFrom;
    return this;
  }

  /**
   * Get validFrom
   * @return validFrom
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(OffsetDateTime validFrom) {
    this.validFrom = validFrom;
  }

  public Token validUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * Get validUntil
   * @return validUntil
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
  }

  public Token tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * The type of data held in this token, will later be an enum
   * @return tokenType
   **/
  @Schema(example = "QR-code", required = true, description = "The type of data held in this token, will later be an enum")
      @NotNull

    public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public Token tokenData(Map<String, Object> tokenData) {
    this.tokenData = tokenData;
    return this;
  }

  public Token putTokenDataItem(String key, Object tokenDataItem) {
    this.tokenData.put(key, tokenDataItem);
    return this;
  }

  /**
   * Arbitrary data the TO may pass along the ticket to the client (e.g. a booking code, base64 encoded binary, QR code), later will be one of several types
   * @return tokenData
   **/
  @Schema(required = true, description = "Arbitrary data the TO may pass along the ticket to the client (e.g. a booking code, base64 encoded binary, QR code), later will be one of several types")
      @NotNull

    public Map<String, Object> getTokenData() {
    return tokenData;
  }

  public void setTokenData(Map<String, Object> tokenData) {
    this.tokenData = tokenData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.validFrom, token.validFrom) &&
        Objects.equals(this.validUntil, token.validUntil) &&
        Objects.equals(this.tokenType, token.tokenType) &&
        Objects.equals(this.tokenData, token.tokenData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validFrom, validUntil, tokenType, tokenData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    validFrom: ").append(toIndentedString(validFrom)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    tokenData: ").append(toIndentedString(tokenData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
