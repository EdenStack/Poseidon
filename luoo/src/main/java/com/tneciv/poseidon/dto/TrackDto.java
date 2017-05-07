package com.tneciv.poseidon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tneciv.poseidon.entity.Track;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Tneciv on 2017/3/30.
 */
@Data
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"id", "name", "createTime"})
public class TrackDto extends Track implements Serializable {

    private static final long serialVersionUID = 5189587397872626808L;

}
