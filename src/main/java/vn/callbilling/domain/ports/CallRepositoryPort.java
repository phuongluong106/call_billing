package vn.callbilling.domain.ports;

import vn.callbilling.domain.model.Call;

public interface CallRepositoryPort {
    void saveCall(Call call);
}
