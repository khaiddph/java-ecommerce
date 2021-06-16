import url from './api';

const getAll = () => {
  return url.get(`/category`);
};

const getById = id => {
  return url.get(`/category/${id}`);
};

const save = data => {
  return url.post('/category', data);
};

const update = (id, data) => {
  return url.put(`/category/${id}`, data);
};

const deleteById = id => {
  return url.delete(`/category/${id}`);
};

const search = title => {
  return url.get(`/category?title=${title}`);
};

export default {
  getAll,
  getById,
  save,
  update,
  deleteById,
  search,
};
