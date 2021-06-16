import url from './api';

const getAll = () => {
  return url.get(`/product`);
};

const getCategory = () => {
  return url.get(`/category`);
};

const getByCategoryId = (categoryId, pageSize, pageNo) => {
  return url.get(`/category/${categoryId}/product?${pageNo}&${pageSize}`);
};
const searchProducts = (categoryId, keyword) => {
  return url.get(`/category/${categoryId}/product?search=${keyword}`);
};

// const getById = id => {
//   return url.get(`/product/${id}`);
// };

const save = (categoryId, data) => {
  return url.post(`/category/${categoryId}/product`, data);
};

const update = (categoryId, productId, data) => {
  return url.put(`/category/${categoryId}/product/${productId}`, data);
};

const deleteById = id => {
  return url.delete(`/product/${id}`);
};

export default {
  getCategory,
  getByCategoryId,
  searchProducts,
  getAll,
  //   getById,
  save,
  update,
  deleteById,
};
