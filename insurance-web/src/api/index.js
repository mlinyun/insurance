import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

// 文件上传接口
export const uploadFile = "/ins/upload/file"
// 获取菜单
export const getMenuList = "/ins/permission/getMenuList"


/**************************************** 验证码接口 ****************************************/
// 验证码渲染图片接口
export const drawCodeImage = "/ins/common/captcha/draw/"
// 初始化验证码接口
export const initCaptcha = (params) => {
    return getNoAuthRequest('/common/captcha/init', params)
}


/**************************************** 用户接口 ****************************************/
// 用户注册接口
export const regist = (params) => {
    return postNoAuthRequest('/user/regist', params)
}
// 用户登录接口
export const login = (params) => {
    return postNoAuthRequest('/login', params)
}
// 获取用户登录信息接口
export const userInfo = (params) => {
    return getRequest('/user/info', params)
}
// 修改用户资料接口
export const userInfoEdit = (params) => {
    return postRequest('/user/edit', params)
}
// 修改用户密码接口
export const changePass = (params) => {
    return postRequest('/user/modifyPass', params)
}
// 解锁验证密码接口
export const unlock = (params) => {
    return postRequest('/user/unlock', params)
}
// 获取用户数据（多条件）接口
export const getUserListData = (params) => {
    return getRequest('/user/getByCondition', params)
}
// 查询用户列表接口
export const getUserList = (params) => {
    return getRequest('/user/getUserList', params)
}
// 启用用户接口
export const enableUser = (params) => {
    return postRequest('/user/enable', params)
}
// 禁用用户接口
export const disableUser = (params) => {
    return postRequest('/user/disable', params)
}
// 删除用户接口
export const deleteUser = (params) => {
    return postRequest('/user/delByIds', params)
}
// 导入用户接口
export const importUserData = (params) => {
    return postBodyRequest('/user/importData', params)
}
// 重置密码接口
export const resetUserPass = (params) => {
    return postRequest('/user/resetPass', params)
}
// 管理员添加用户接口
export const addUser = (params) => {
    return postRequest('/user/admin/add', params)
}
// 管理员修改资料接口
export const editUser = (params) => {
    return postRequest('/user/admin/edit', params)
}
// 根据部门查询用户接口
export const getUserByDepartmentId = (params) => {
    return getRequest('/user/getByDepartmentId', params)
}


/**************************************** IP定位接口 ****************************************/
// 获取IP信息接口 
export const ipInfo = (params) => {
    return getRequest('/common/ip/info', params)
}


/**************************************** 部门管理接口 ****************************************/
// 获取一级部门
export const initDepartment = (params) => {
    return getRequest('/department/getByParentId', params)
}
// 加载部门子级数据
export const loadDepartment = (params) => {
    return getRequest('/department/getByParentId', params)
}
// 模糊搜索部门接口
export const searchDepartment = (params) => {
    return getRequest('/department/search', params)
}
// 添加部门接口
export const addDepartment = (params) => {
    return postRequest('/department/add', params)
}
// 编辑部门接口
export const editDepartment = (params) => {
    return postRequest('/department/edit', params)
}
// 删除部门接口
export const deleteDepartment = (params) => {
    return postRequest('/department/delByIds', params)
}
export const getMyUserListData = (params) => {
    return getRequest('/myUser/getByPage', params)
}


/**************************************** 字典数据接口 ****************************************/
// 获取全部字典接口
export const getAllDictList = (params) => {
    return getRequest('/dict/getAll', params)
}
// 添加字典接口
export const addDict = (params) => {
    return postRequest('/dict/add', params)
}
// 编辑字典接口
export const editDict = (params) => {
    return postRequest('/dict/edit', params)
}
// 删除字典接口
export const deleteDict = (params) => {
    return postRequest('/dict/delByIds', params)
}
// 搜索字典接口
export const searchDict = (params) => {
    return getRequest('/dict/search', params)
}
// 获取全部字典数据接口
export const getAllDictDataList = (params) => {
    return getRequest('/dictData/getByCondition', params)
}
// 添加字典数据接口
export const addDictData = (params) => {
    return postRequest('/dictData/add', params)
}
// 编辑字典数据接口
export const editDictData = (params) => {
    return postRequest('/dictData/edit', params)
}
// 删除字典数据接口
export const deleteData = (params) => {
    return postRequest('/dictData/delByIds', params)
}


/**************************************** 字典数据值接口 ****************************************/
// 查询单个数据字典的值
export const getDictDataByType = (type, params) => {
    return getRequest(`/dictData/getByType/${type}`, params)
}


/**************************************** 文件管理接口 ****************************************/
// 查询系统文件接口
export const getFileListData = (params) => {
    return getRequest('/file/getByCondition', params)
}
// 复制文件接口
export const copyFile = (params) => {
    return postRequest('/file/copy', params)
}
// 重命名文件接口
export const renameFile = (params) => {
    return postRequest('/file/rename', params)
}
// 删除文件接口
export const deleteFile = (params) => {
    return postRequest('/file/delete', params)
}



/**************************************** 设置接口 ****************************************/
// 查看单个配置接口
export const getOneSetting = (params) => {
    return getRequest('/setting/getOne', params)
}
// 修改单个配置接口
export const setOneSetting = (params) => {
    return getRequest('/setting/setOne', params)
}


/**************************************** 代码生成接口 ****************************************/
// 读取实体类接口
export const generateTable = (name, rowNum, params) => {
    return postBodyRequest(`/generate/table/${name}/${rowNum}`, params)
}
// 生成代码接口
export const getEntityData = (path, params) => {
    return getRequest(`/generate/getEntityData/${path}`, params)
}


/**************************************** 个人门户接口 ****************************************/
// 查询个人门户菜单A接口
export const getMyDoorList = (params) => {
    return postRequest('/myDoor/getMyDoorList', params)
}
// 获取个人门户菜单B接口
export const getMyDoorList6 = (params) => {
    return postRequest('/myDoor/getMyDoorList6', params)
}
// 修改个人门户菜单接口
export const setMyDoorList = (params) => {
    return postRequest('/myDoor/setMyDoorList', params)
}


/**************************************** 日志管理接口 ****************************************/
// 查询日志接口
export const getLogListData = (params) => {
    return getRequest('/log/getAllByPage', params)
}


/**************************************** 菜单/权限管理接口 ****************************************/
// 添加权限接口
export const addPermission = (params) => {
    return postRequest('/permission/add', params)
}
// 编辑权限接口
export const editPermission = (params) => {
    return postRequest('/permission/edit', params)
}
// 删除权限接口
export const deletePermission = (params) => {
    return postRequest('/permission/delByIds', params)
}
// 搜索权限接口
export const searchPermission = (params) => {
    return getRequest('/permission/search', params)
}
// 查询菜单权限拥有者接口
export const getUserByPermission = (params) => {
    return getRequest('/permission/getUserByPermission', params)
}
// 获取全部权限数据接口接口
export const getAllPermissionList = (params) => {
    return getRequest('/permission/getAllList', params)
}


/**************************************** 角色管理接口 ****************************************/
// 分页获取角色数据接口接口
export const getRoleList = (params) => {
    return getRequest('/role/getAllByPage', params)
}
// 添加角色接口接口
export const addRole = (params) => {
    return postRequest('/role/save', params)
}
// 编辑角色接口接口
export const editRole = (params) => {
    return postRequest('/role/edit', params)
}
// 删除角色接口接口
export const deleteRole = (params) => {
    return postRequest('/role/delByIds', params)
}
// 配置默认角色接口接口
export const setDefaultRole = (params) => {
    return postRequest('/role/setDefault', params)
}
// 修改菜单权限接口接口
export const editRolePerm = (params) => {
    return postRequest('/role/editRolePerm', params)
}
// 查询全部角色接口
export const getAllRoleList = (params) => {
    return getRequest('/role/getAllList', params)
}


/**************************************** 参保人员管理接口 ****************************************/
// 查询单条参保人员接口
export const getRosterOne = (params) => {
    return getRequest('/roster/getOne', params)
}
// 查询参保人员接口
export const getRosterList = (params) => {
    return getRequest('/roster/getByPage', params)
}
// 查询全部参保人员个数接口
export const getRosterCount = (params) => {
    return getRequest('/roster/count', params)
}
// 新增参保人员接口
export const addRoster = (params) => {
    return postRequest('/roster/insert', params)
}
// 编辑参保人员接口
export const editRoster = (params) => {
    return postRequest('/roster/update', params)
}
// 增改参保人员接口
export const addOrEditRoster = (params) => {
    return postRequest('/roster/insertOrUpdate', params)
}
// 删除参保人员接口
export const deleteRoster = (params) => {
    return postRequest('/roster/delByIds', params)
}
// 禁用参保人员接口
export const disableOne = (params) => {
    return getRequest('/roster/disableOne', params)
}
// 启用参保人员接口
export const enableOne = (params) => {
    return getRequest('/roster/enableOne', params)
}
// 医保余额充值接口
export const addMoney = (params) => {
    return getRequest('/roster/addMoney', params)
}


/**************************************** 医用设备档案接口 ****************************************/
// 查询行政耗材品类接口
export const getAssetsTypeList = (params) => {
    return getRequest('/medicalAssets/getByPage', params)
}
// 增改资产种类接口
export const addAssetsType = (params) => {
    return postRequest('/medicalAssets/insertOrUpdate', params)
}
// 删除资产种类接口
export const editAssetsType = (params) => {
    return postRequest('/medicalAssets/insertOrUpdate', params)
}
// 删除资产种类接口
export const deleteAssetsType = (params) => {
    return postRequest('/medicalAssets/delByIds', params)
}


/**************************************** 医疗资产出库单接口 ****************************************/
// 查询资产出库清单接口
export const getWarehouseOutList = (params) => {
    return getRequest('/medicalAssetsOutboundOrder/getByPage', params)
}
export const getAssetListData1 = (params) => {
    return getRequest('/medicalAssets/getByPage?natureType=1', params)
}
export const getAssetListData2 = (params) => {
    return getRequest('/medicalAssets/getByPage?natureType=2', params)
}
// 添加资产出库接口
export const addWarehouseOut = (params) => {
    return postRequest('/medicalAssetsOutboundOrder/insertOrUpdate', params)
}
// 编辑资产出库接口
export const editWarehouseOut = (params) => {
    return postRequest('/medicalAssetsOutboundOrder/insertOrUpdate', params)
}
// 删除资产出库清单接口
export const deleteWarehouseOut = (params) => {
    return postRequest('/medicalAssetsOutboundOrder/delByIds', params)
}


/**************************************** 医疗资产入库单管理接口 ****************************************/
// 查询资产入库清单接口
export const getWarehousingList = (params) => {
    return getRequest('/medicalAssetsWarehousingOrder/getByPage', params)
}
export const getMedicalAssetsListData1 = (params) => {
    return getRequest('/medicalAssets/getByPage?natureType=1', params)
}
export const getMedicalAssetsListData2 = (params) => {
    return getRequest('/medicalAssets/getByPage?natureType=2', params)
}
// 添加资产入库接口
export const addWarehousing = (params) => {
    return postRequest('/medicalAssetsWarehousingOrder/insertOrUpdate', params)
}
// 编辑资产入库接口
export const editWarehousing = (params) => {
    return postRequest('/medicalAssetsWarehousingOrder/insertOrUpdate', params)
}
// 删除资产入库清单接口
export const deleteWarehousing = (params) => {
    return postRequest('/medicalAssetsWarehousingOrder/delByIds', params)
}


/**************************************** 医疗保险管理接口 ****************************************/
// 查询单条医疗保险接口
export const getInsuranceOne = (params) => {
    return getRequest('/insurance/getOne', params)
}
// 查询全部保险接口
export const getInsuranceList = (params) => {
    return getRequest('/insurance/getByPage', params)
}
// 查询全部医疗保险个数接口
export const getInsuranceCount = (params) => {
    return getRequest('/insurance/count', params)
}
// 新增医疗保险接口
export const addInsurance = (params) => {
    return postRequest('/insurance/insert', params)
}
// 编辑医疗保险接口
export const editInsurance = (params) => {
    return postRequest('/insurance/update', params)
}
// 增改医疗保险接口
export const addOrEditInsurance = (params) => {
    return postRequest('/insurance/insertOrUpdate', params)
}
// 删除医疗保险接口
export const deleteInsurance = (params) => {
    return postRequest('/insurance/delByIds', params)
}
// 查询全部保险接口
export const getAllInsuranceList = (params) => {
    return getRequest('/insurance/getAll', params)
}


/**************************************** 手术管理接口 ****************************************/
// 查询单条手术接口
export const getOperationOne = (params) => {
    return getRequest('/operation/getOne', params)
}
// 查询手术接口
export const getOperationList = (params) => {
    return getRequest('/operation/getByPage', params)
}
// 查询全部手术个数接口
export const getOperationCount = (params) => {
    return getRequest('/operation/count', params)
}
// 新增手术接口
export const addOperation = (params) => {
    return postRequest('/operation/insert', params)
}
// 编辑手术接口
export const editOperation = (params) => {
    return postRequest('/operation/update', params)
}
// 增改手术接口
export const addOrEditOperation = (params) => {
    return postRequest('/operation/insertOrUpdate', params)
}
// 删除手术接口
export const deleteOperation = (params) => {
    return postRequest('/operation/delByIds', params)
}


/**************************************** 看病单管理接口 ****************************************/
// 查询单条看病单接口
export const getSeeDoctorOne = (params) => {
    return getRequest('/seeDoctor/getOne', params)
}
// 查询看病单接口
export const getSeeDoctorList = (params) => {
    return getRequest('/seeDoctor/getByPage', params)
}
// 查询全部看病单个数接口
export const getSeeDoctorCount = (params) => {
    return getRequest('/seeDoctor/count', params)
}
// 新增看病单接口
export const addSeeDoctor = (params) => {
    return postRequest('/seeDoctor/insert', params)
}
// 编辑看病单接口
export const editSeeDoctor = (params) => {
    return postRequest('/seeDoctor/update', params)
}
// 增改看病单接口
export const addOrEditSeeDoctor = (params) => {
    return postRequest('/seeDoctor/insertOrUpdate', params)
}
// 删除看病单接口
export const deleteSeeDoctor = (params) => {
    return postRequest('/seeDoctor/delByIds', params)
}
// 查询药物档案接口
export const getMedicineList = (params) => {
    return getRequest('/operation/getByPage', params)
}


/**************************************** 保险审核单管理接口 ****************************************/
// 查询单条保险审核单
export const getExamineOne = (params) => {
    return getRequest('/examine/getOne', params)
}
// 查询保险审核单
export const getExamineList = (params) => {
    return getRequest('/examine/getByPage', params)
}
// 查询全部保险审核单个数
export const getExamineCount = (params) => {
    return getRequest('/examine/count', params)
}
// 新增保险审核单
export const addExamine = (params) => {
    return postRequest('/examine/insert', params)
}
// 编辑保险审核单
export const editExamine = (params) => {
    return postRequest('/examine/update', params)
}
// 增改保险审核单
export const addOrEditExamine = (params) => {
    return postRequest('/examine/insertOrUpdate', params)
}
// 删除保险审核单
export const deleteExamine = (params) => {
    return postRequest('/examine/delByIds', params)
}
// 通过保险单
export const pass = (params) => {
    return postRequest('/examine/pass', params)
}
// 驳回保险单
export const notPass = (params) => {
    return postRequest('/examine/notPass', params)
}
