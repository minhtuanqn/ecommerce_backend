package com.realestatebackend.convertor;

import com.realestatebackend.customexception.NotFoundFieldOfClassException;
import com.realestatebackend.model.PaginationRequestModel;
import com.realestatebackend.model.ResourceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static com.realestatebackend.utils.ValidatorUtils.checkExistFieldOfClass;

/**
 * Class for support pagination
 * @param <M> Type of model
 * @param <E> Type of entity
 */
public class PaginationConvertor<M, E> {

    /**
     * Create pageable for sort
     * @param paginationRequestModel
     * @param defaultSortBy
     * @return
     */
    public Pageable convertToPageable(PaginationRequestModel paginationRequestModel, String defaultSortBy, Class<E> classType) {
        // Define sort by field for paging
        String sortBy = defaultSortBy;
        if(paginationRequestModel.getSortBy() != null) {
            if(!checkExistFieldOfClass(classType, paginationRequestModel.getSortBy()))
                throw new NotFoundFieldOfClassException("Can not define sortBy");
            sortBy = paginationRequestModel.getSortBy();
        }

        //Build Pageable
        Pageable pageable;
        if (paginationRequestModel.getSortType() != null && paginationRequestModel.getSortType().equals("dsc")) {
            pageable = PageRequest.of(paginationRequestModel.getPageIndex(), paginationRequestModel.getLimit(), Sort.by(sortBy).descending());
        } else {
            pageable = PageRequest.of(paginationRequestModel.getPageIndex(), paginationRequestModel.getLimit(), Sort.by(sortBy).ascending());
        }
        return pageable;
    }

    /**
     * Build pagination
     * @param pagination
     * @param page
     * @param resource
     * @return
     */
    public ResourceModel<M> buildPagination(PaginationRequestModel pagination, Page<E> page, ResourceModel<M> resource) {
        resource.setTotalPage(page.getTotalPages());
        resource.setTotalRecord((int) page.getTotalElements());
        resource.setPageIndex(pagination.getPageIndex());
        resource.setLimit(pagination.getLimit());
        return resource;
    }
}
