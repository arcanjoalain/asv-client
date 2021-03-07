package br.com.asv.client.ws;

import java.util.Collection;


import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.fge.jsonpatch.JsonPatch;

public interface IWSClient<D,I> {

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll(@RequestParam(value = "search", required = false) String search) ;
	
	@GetMapping(path = "/{id}")
	@ResponseBody
	public ResponseEntity<?> findOne(@PathVariable("id") I id);
	
	@GetMapping(path = "/page")
	@ResponseBody
	public ResponseEntity<?> findAll(@RequestParam(value = "search", required = false) String search, Pageable pageable);
	
	@GetMapping(path = "/page/{status}")
	@ResponseBody
	public ResponseEntity<?> findAllPage(@PathVariable("status") String status, Pageable pageable);
	
	@GetMapping(path = "/status/{status}")
	@ResponseBody
	public ResponseEntity<?> findAllStatus(@PathVariable("status") String status);
	
	@GetMapping(path = "/enabled")
	@ResponseBody
	public ResponseEntity<?> findAllEnabled();
	
	@GetMapping(path = "/enabled/page")
	@ResponseBody
	public ResponseEntity<?> findAllEnabled(Pageable pageable);
	
	@GetMapping(path = "/disabled")
	@ResponseBody
	public ResponseEntity<?> findAllDisabled();
	
	@GetMapping(path = "/disabled/page")
	@ResponseBody
	public ResponseEntity<?> findAllDisabled( Pageable pageable);
	
	@GetMapping(path = "/count")
	public @ResponseBody ResponseEntity<?> countAll(@RequestParam(value = "search", required = false) String search);
	
	@PostMapping(path = "/collection")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody Collection<D> collection);
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save( @RequestBody  D dto ) ;
	
	@DeleteMapping(path = "/collection/disabled")
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody  Collection<D> collection);
	
	@DeleteMapping(path = "/disabled/{id}")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable("id") I id);
	
	@DeleteMapping(path = "/remove/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> remove(@PathVariable("id") I id);

	@DeleteMapping(path = "/remove")
	@ResponseBody
	public ResponseEntity<?> remove(@RequestBody Collection<D> collection);
	
	@PatchMapping(path = "/collection/enabled")
	@ResponseBody
	public ResponseEntity<?> recovery(@RequestBody  Collection<D> collection);
	
	@PatchMapping(path = "/enabled/{id}")
	@ResponseBody
	public ResponseEntity<?> recovery(@PathVariable("id") I id);
	
	@PutMapping
	public ResponseEntity<?> update( @RequestBody  D dto);
	
	@PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
	public ResponseEntity<?> patchDto(@PathVariable("id") I id, @RequestBody JsonPatch patchDto);
}
