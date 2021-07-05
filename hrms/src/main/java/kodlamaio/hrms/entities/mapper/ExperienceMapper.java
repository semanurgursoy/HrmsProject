package kodlamaio.hrms.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import kodlamaio.hrms.entities.concretes.cv.Experience;
import kodlamaio.hrms.entities.dtos.cv.ExperienceDto;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

	@Mapping(target = "jobSeekerCV.id", source = "jobSeekerCVId")
	@Mapping(target = "jobPosition.id", source = "jobPositionId")
	Experience map(ExperienceDto experienceDto);

} 
