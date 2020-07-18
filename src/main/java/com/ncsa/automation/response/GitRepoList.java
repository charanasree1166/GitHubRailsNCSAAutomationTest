package com.ncsa.automation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ncsa.automation.models.Gitrepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitRepoList {

    @NotNull
    private List<Gitrepo> gitRepos;

}
