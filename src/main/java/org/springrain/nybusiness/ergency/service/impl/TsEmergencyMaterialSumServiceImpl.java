package org.springrain.nybusiness.ergency.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springrain.nybusiness.ergency.entity.TsEmergencyMaterialSum;
import org.springrain.nybusiness.ergency.entity.TsErgencyInvestigation;
import org.springrain.nybusiness.ergency.service.ITsEmergencyMaterialSumService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.service.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-11-05 21:18:49
 * @see org.springrain.nybusiness.ergency.service.impl.TsEmergencyMaterialSum
 */
@Service("tsEmergencyMaterialSumService")
public class TsEmergencyMaterialSumServiceImpl extends BaseSpringrainServiceImpl implements ITsEmergencyMaterialSumService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      TsEmergencyMaterialSum tsEmergencyMaterialSum=(TsEmergencyMaterialSum) entity;
	       return super.save(tsEmergencyMaterialSum).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      TsEmergencyMaterialSum tsEmergencyMaterialSum=(TsEmergencyMaterialSum) entity;
		 return super.saveorupdate(tsEmergencyMaterialSum).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 TsEmergencyMaterialSum tsEmergencyMaterialSum=(TsEmergencyMaterialSum) entity;
	return super.update(tsEmergencyMaterialSum);
    }
    @Override
	public TsEmergencyMaterialSum findTsEmergencyMaterialSumById(Object id) throws Exception{
	 return super.findById(id,TsEmergencyMaterialSum.class);
	}
	
/**
 * 列表查询,每个service都会重载,要把sql语句封装到service中,Finder只是最后的方案
 * @param finder
 * @param page
 * @param clazz
 * @param o
 * @return
 * @throws Exception
 */
        @Override
    public <T> List<T> findListDataByFinder(Finder finder, Page page, Class<T> clazz,
			Object o) throws Exception{
			 return super.findListDataByFinder(finder,page,clazz,o);
			}
	/**
	 * 根据查询列表的宏,导出Excel
	 * @param finder 为空则只查询 clazz表
	 * @param ftlurl 类表的模版宏
	 * @param page 分页对象
	 * @param clazz 要查询的对象
	 * @param o  querybean
	 * @return
	 * @throws Exception
	 */
		@Override
	public <T> File findDataExportExcel(Finder finder,String ftlurl, Page page,
			Class<T> clazz, Object o)
			throws Exception {
			 return super.findDataExportExcel(finder,ftlurl,page,clazz,o);
		}

	@Override
	public List<TsEmergencyMaterialSum> finderTsMaillistForList(Page page,
			TsEmergencyMaterialSum tsEmergencyMaterialSum, List<String> listCompany) throws Exception {
		if(CollectionUtils.isEmpty(listCompany)){
			return null;
		}
		Finder finder = new Finder();
		finder.append("SELECT * FROM `ts_emergency_material_sum` t where t.company_id in (:companyId)")
		.setParam("companyId", listCompany);
		return super.queryForList(finder, TsEmergencyMaterialSum.class, page);
	}

}
