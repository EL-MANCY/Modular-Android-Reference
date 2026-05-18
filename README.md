# Modular-Android-Reference

A modular Android sandbox practicing modern architecture, offline caching, and networking.

## Architecture (layers + features)

This project mixes **layer modules** (shared capabilities) with **feature modules** (vertical
slices).

**Layer modules** provide reusable building blocks:

- `core:caching` for DataStore + crypto
- `core:network` for Retrofit/OkHttp setup and shared remote utilities
- `core:presentation` for base UI components (CoreActivity, CoreFragment, shared UI assets)

**Feature modules** own their data/domain/presentation pieces and depend on the core layers:

- `feature:auth` (data + domain + presentation)
- `feature:jsonplaceholder` (domain + data wrapper around core network)

```
app
├── feature:auth
│   ├── data
│   ├── domain
│   └── presentation
├── feature:jsonplaceholder
│   ├── data
│   └── domain
└── core
    ├── caching
    ├── network
    └── presentation
```

## Why this mix?

- **Layered core** keeps common infrastructure consistent across the app.
- **Feature slices** keep business logic and UI close together, making changes safer and more
  focused.

## Next steps

- Add new features by following the `feature:auth` structure.
- If a feature needs remote data, use `core:network` inside its data layer.
