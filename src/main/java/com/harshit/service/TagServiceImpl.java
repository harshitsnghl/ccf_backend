package com.harshit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.harshit.entity.Tag;
import com.harshit.exception.TagExistsException;
import com.harshit.exception.TagNotFoundException;
import com.harshit.repository.TagRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
	private final TagRepository tagRepository;

	@Override
	public Tag getTagById(Long id) {
		return tagRepository.findById(id).orElseThrow(TagNotFoundException::new);
	}

	@Override
	public Tag getTagByName(String name) {
		return tagRepository.findTagByName(name).orElseThrow(TagNotFoundException::new);
	}

	@Override
	public Tag createNewTag(String name) {
		try {
			Tag tag = getTagByName(name);
			if (tag != null) {
				throw new TagExistsException();
			}
		} catch (TagNotFoundException e) {
			Tag newTag = new Tag();
			newTag.setName(name);
			newTag.setTagUseCounter(1);
			newTag.setDateCreated(new Date());
			newTag.setDateLastModified(new Date());
			return tagRepository.save(newTag);
		}
		return null;
	}

	@Override
	public Tag increaseTagUseCounter(String name) {
		Tag targetTag = getTagByName(name);
		targetTag.setTagUseCounter(targetTag.getTagUseCounter() + 1);
		targetTag.setDateLastModified(new Date());
		return tagRepository.save(targetTag);
	}

	@Override
	public Tag decreaseTagUseCounter(String name) {
		Tag targetTag = getTagByName(name);
		targetTag.setTagUseCounter(targetTag.getTagUseCounter() - 1);
		targetTag.setDateLastModified(new Date());
		return tagRepository.save(targetTag);
	}

	@Override
	public List<Tag> getTimelineTags() {
		return tagRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "tagUseCounter"))).getContent();
	}
}
