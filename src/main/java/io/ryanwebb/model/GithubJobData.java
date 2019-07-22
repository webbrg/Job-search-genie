package io.ryanwebb.model;

public class GithubJobData {
	public String id;
	public String type;
	public String url;
	public String created_at;
	public String company;
	public String company_url;
	public String location;
	public String title;
	public String description;
	public String how_to_apply;
	public String company_logo;
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public String getUrl() 
	{
		return url;
	}

	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getCreated_at() 
	{
		return created_at;
	}

	public void setCreated_at(String created_at) 
	{
		this.created_at = created_at;
	}

	public String getCompany() 
	{
		return company;
	}

	public void setCompany(String company) 
	{
		this.company = company;
	}

	public String getCompany_url() 
	{
		return company_url;
	}

	public void setCompany_url(String company_url) 
	{
		this.company_url = company_url;
	}

	public String getLocation() 
	{
		return location;
	}

	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getHow_to_apply() 
	{
		return how_to_apply;
	}

	public void setHow_to_apply(String how_to_apply) 
	{
		this.how_to_apply = how_to_apply;
	}

	public String getCompany_logo() 
	{
		return company_logo;
	}

	public void setCompany_logo(String company_logo) 
	{
		this.company_logo = company_logo;
	}

	@Override
	public String toString() {
		return "GithubJobData [id=" + id + ", type=" + type + ", url=" + url + ", created_at=" + created_at
				+ ", company=" + company + ", company_url=" + company_url + ", location=" + location + ", title="
				+ title + ", description=" + description + ", how_to_apply=" + how_to_apply + ", company_logo="
				+ company_logo + "]";
	}
	
}