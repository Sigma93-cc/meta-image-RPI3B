DESCRIPTION = "Receipt provides udev rules for device for search waveshare display"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install(){
    install -d ${D}${sysconfdir}/udev/rules.d/
    cat > ${D}${sysconfdir}/udev/rules.d/99-waveshare.rules <<EOF
SUBSYSTEM=="graphics", DRIVERS=="${PANEL_FB_DRIVER}", SYMLINK+="${PANEL_FB_SYMLINK}", TAG+="systemd"
EOF
}

FILES:${PN} = "${sysconfdir}/udev/rules.d/99-waveshare.rules"