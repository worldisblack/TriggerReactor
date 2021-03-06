package io.github.wysohn.triggerreactor.core.config.source;

import io.github.wysohn.triggerreactor.core.config.IConfigSource;

import java.util.Optional;
import java.util.Set;

public class DelegatedConfigSource implements IConfigSource {
    private final IConfigSource configSource;

    public DelegatedConfigSource(IConfigSource configSource) {
        this.configSource = configSource;
    }

    public static String[] toPath(String key) {
        return IConfigSource.toPath(key);
    }

    @Override
    public boolean fileExists() {
        return configSource.fileExists();
    }

    @Override
    public <T> Optional<T> get(String key, Class<T> asType) {
        return configSource.get(key, asType);
    }

    @Override
    public <T> Optional<T> get(String key) {
        return configSource.get(key);
    }

    @Override
    public void put(String key, Object value) {
        configSource.put(key, value);
    }

    @Override
    public boolean has(String key) {
        return configSource.has(key);
    }

    @Override
    public Set<String> keys() {
        return configSource.keys();
    }

    @Override
    public boolean isSection(String key) {
        return configSource.isSection(key);
    }

    @Override
    public void reload() {
        configSource.reload();
    }

    @Override
    public void saveAll() {
        configSource.saveAll();
    }

    @Override
    public void disable() {
        configSource.disable();
    }

    @Override
    public void delete() {
        configSource.delete();
    }
}
