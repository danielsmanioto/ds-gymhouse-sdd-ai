package com.dsgymhouse.api.health;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class HealthControllerTest {

    @Test
    void shouldReturnExpectedHealthPayload() {
        HealthController controller = new HealthController();

        Map<String, String> response = controller.health();

        assertThat(response)
                .containsEntry("status", "ok")
                .containsEntry("service", "ds-gym-house-backend")
                .hasSize(2);
    }
}
